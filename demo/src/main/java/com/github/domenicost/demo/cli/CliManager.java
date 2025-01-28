package com.github.domenicost.demo.cli;

import java.util.List;
import java.util.Scanner;
import com.github.domenicost.demo.db.entity.Utente;
import com.github.domenicost.demo.db.service.UtenteService;

public class CliManager {

    private Scanner scanner;
    private UtenteService utenteService;
    // Costruttore
    public CliManager(UtenteService utenteService) {

        scanner = new Scanner(System.in);
        this.utenteService = utenteService;

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
        System.out.println("9. Esci");
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

        Utente u = new Utente();

        System.out.println("Nome:");
        String nome = scanner.nextLine();
        u.setNome(nome);

        System.out.println("Cognome:");
        String cognome = scanner.nextLine();
        u.setCognome(cognome);

        System.out.println("Username:");
        String username = scanner.nextLine();
        u.setUsername(username);

        System.out.println("Password:");
        String password = scanner.nextLine();
        u.setPassword(password);

        System.out.println("Credito:");
        String strCredito = scanner.nextLine();
        int credito = Integer.parseInt(strCredito);
        u.setCredito(credito);

        utenteService.save(u);
    }

    private void edit() {

        System.out.println("edit id:");
        String strId = scanner.nextLine();
        Long id = Long.parseLong(strId);
        Utente u = utenteService.findById(id);

        if (u == null) {

            System.out.println("Utente non trovato");
            return;
        }

        System.out.println("Nome: (" + u.getNome() + ")");
        String nome = scanner.nextLine();
        u.setNome(nome);

        System.out.println("Cognome: (" + u.getCognome() + ")");
        String cognome = scanner.nextLine();
        u.setCognome(cognome);

        System.out.println("Username: (" + u.getUsername() + ")");
        String username = scanner.nextLine();
        u.setUsername(username);

        System.out.println("Password: (" + u.getPassword() + ")");
        String password = scanner.nextLine();
        u.setPassword(password);

        System.out.println("Credito: (" + u.getCredito() + ")");
        String strCredito = scanner.nextLine();
        int credito = Integer.parseInt(strCredito);
        u.setCredito(credito);

        utenteService.save(u);
    }

    private void delete() {

        System.out.println("delete id:");
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

}