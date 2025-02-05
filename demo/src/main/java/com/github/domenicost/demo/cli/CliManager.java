package com.github.domenicost.demo.cli;

import java.util.List;
import java.util.Scanner;

import com.github.domenicost.demo.db.entity.Role;
import com.github.domenicost.demo.db.entity.Utente;
import com.github.domenicost.demo.db.service.RoleServices;
import com.github.domenicost.demo.db.service.UtenteService;

public class CliManager {

    private Scanner scanner;
    private UtenteService utenteService;
    private RoleServices roleService;

    // Costruttore
    public CliManager(UtenteService utenteService, RoleServices roleService) {

        scanner = new Scanner(System.in);
        this.utenteService = utenteService;
        this.roleService = roleService;

        printOptions();
    }

    // Metodo menu
    private void printOptions() {

        System.out.println("Operazioni:");
        System.out.println("1. Visualizza Utenti");
        System.out.println("2. Inserisci Nuovo Utente");
        System.out.println("3. Modifica Utente");
        System.out.println("4. Elimina Utente");
        System.out.println("5. Ricerca Utenti per Iniziale");
        System.out.println("6. Visualizza Utenti con Credito +10€");
        System.out.println("7. Visualizza Utenti con Credito positivo ma -10€");
        System.out.println("8. Visualizza Utenti con Nome o Congome NULL");
        System.out.println("9. Cambia Permessi");
        System.out.println("10. Esci");
        System.out.println("");

        String strValue = scanner.nextLine();
        int value = Integer.parseInt(strValue);

        switch (value) {

            case 1:
                readAll();
                break;
            case 2:
                insert();
                break;
            case 3:
                edit();
                break;
            case 4:
                delete();
                break;
            case 5:
                searchUser();
                break;
            case 6:
                verificaCreditoUno();
                break;
            case 7:
                verificaCreditoDue();
                break;
            case 8:
                userNull();
                break;
            case 9:
                cambiaRuolo();
                break;

            case 10:
                return;

            default:
                System.out.println("Operazione non valida");
                break;
        }

        printOptions();
    }

    private void readAll() {

        List<Utente> utenti = utenteService.findAll();
        System.out.println("Lista Utenti:");
        System.out.println(utenti);
        System.out.println("-------------------------------------");
    }

    private void insert() {

        Utente utente = new Utente();

        save(utente);
    }

    private void edit() {

        System.out.println("edit id:");
        String strId = scanner.nextLine();
        Long id = Long.parseLong(strId);
        Utente utente = utenteService.findById(id);

        if (utente == null) {

            System.out.println("Utente non trovato");
            return;
        }

        save(utente);
    }

    private void save(Utente utente) {

        boolean isInsert = (utente.getId() == null);

        System.out.println("Nome:" + (isInsert ? "" : "(" + utente.getNome() + ")"));
        String nome = scanner.nextLine();
        utente.setNome(nome);

        System.out.println("Cognome:" + (isInsert ? "" : "(" + utente.getCognome() + ")"));
        String cognome = scanner.nextLine();
        utente.setCognome(cognome);

        System.out.println("Username:" + (isInsert ? "" : "(" + utente.getUsername() + ")"));
        String username = scanner.nextLine();
        utente.setUsername(username);

        System.out.println("Password:" + (isInsert ? "" : "(" + utente.getPassword() + ")"));
        String password = scanner.nextLine();
        utente.setPassword(password);

        System.out.println("Credito:" + (isInsert ? "" : "(" + utente.getCredito() + ")"));
        String strCredito = scanner.nextLine();
        int credito = Integer.parseInt(strCredito);
        utente.setCredito(credito);

        // Blocco Relazionale
        System.out.println("Permessi: ");
        printRoles();
        System.out.print("Inserisci RoleId per assegnare il permesso: ");
        String strRoleId = scanner.nextLine();
        Long roleId = Long.parseLong(strRoleId);
        Role role = roleService.findById(roleId);
        utente.setRole(role);

        utenteService.save(utente);
        System.out.println("Utente salvato");
        System.out.println();
    }

    private void printRoles() {
        System.out.println("Ruoli: ");
        System.out.println(roleService.findAll());
        System.out.println();
    }

    private void delete() {

        System.out.println("utente id:");
        String strId = scanner.nextLine();
        Long id = Long.parseLong(strId);

        Utente p = utenteService.findById(id);

        if (p != null) {
            utenteService.delete(p);
            System.out.println("Utente " + strId + " eliminato");
        } else
            System.out.println("Utente non trovato");

    }

    private void searchUser() {

        List<Utente> searchUsers = utenteService.findByNomeStartingWithA();
        System.out.println("Utenti che iniziano per 'a': " + searchUsers);

    }

    private void userNull() {
        List<Utente> usersNull = utenteService.findByNomeNullOrCognomeNull();
        System.out.println("Utenti con nome o cognome null: " + usersNull);

    }

    private void verificaCreditoUno() {
        List<Utente> creditoMaggiore = utenteService.findByCreditoGreatherThan10();
        System.out.println("Utenti con credito maggiore di 10€: " + creditoMaggiore);
    }

    private void verificaCreditoDue() {
        List<Utente> creditoPositivo = utenteService.findyByCreditoBetween0And10();
        System.out.println("Utenti con credito positivo ma minore di 10€: " + creditoPositivo);
    }

    private void cambiaRuolo() {
        readAll();
        String strUserId = scanner.nextLine();
        Long userId = Long.parseLong(strUserId);
        Utente user = utenteService.findById(userId);
        printRoles();
        System.out.print("Inserisci nuova RoleId: ");
        String strRoleId = scanner.nextLine();
        Long roleId = Long.parseLong(strRoleId);
        Role role = roleService.findById(roleId);
        user.setRole(role);
    }

}