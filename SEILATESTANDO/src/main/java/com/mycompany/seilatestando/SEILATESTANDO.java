/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seilatestando;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.neo4j.driver.Values;
import org.neo4j.driver.Config;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import static org.neo4j.driver.Values.parameters;

/**
 *
 * @author Ryzen
 */
public class SEILATESTANDO {
    private static SEILATESTANDOoperations operations;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        operations = new SEILATESTANDOoperations();
        scanner = new Scanner(System.in);


        boolean running = true;
        while (running) {
        System.out.println("===================================================Menu ==================================================");
        System.out.println("1.  Add Cliente     \t 2.  Delete Cliente     \t 3.  Update Cliente      \t 4.  List Clientes      |");
        System.out.println("5.  Add Funcionario \t 6.  Delete Funcionario \t 7.  Update Funcionario  \t 8.  List Funcionario   |");
        System.out.println("9.  Add Material    \t 10. Delete Material    \t 11. Update Material     \t 12. List Material      |");
        System.out.println("13. Add Produto     \t 14. Delete Produto     \t 15. Update Produto      \t 16. List Produto       |");
        System.out.println("17. Add Pedido      \t 18. Delete Pedido      \t 19. Update Pedido       \t 20. List Pedido        |");
        System.out.println("21. cliente/pedido      || 22. produto/material || 23. pedido/funcionario || 24. pedido/produto         \t|LISTAS");
        System.out.println("25. produto mediano     || 26. pedido murilos   || 27. pedido pequeno     ||                            \t|RELATORIOS");
        System.out.println("28. Exit");
        System.out.println("==========================================================================================================");
        System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    operations.addCliente();
                    break;
                case 2:
                    operations.deleteCliente();
                    break;
                case 3:
                    operations.updateCliente();
                    break;
                case 4:
                    operations.listCliente();
                    break;
                /////////////////////////////////////////////funcionario
                case 5:
                    operations.addFuncionario();
                    break;
                case 6:
                    operations.deleteFuncionario();
                    break;
                case 7:
                    operations.updateFuncionario();
                    break;
                case 8:
                    operations.listFuncionario();
                    break;
                /////////////////////////////////////////////material
                case 9:
                    operations.addMaterial();
                    break;
                case 10:
                    operations.deleteMaterial();
                    break;
                case 11:
                    operations.updateMaterial();
                    break;
                case 12:
                    operations.listMaterial();
                    break;
                case 13:
                    operations.addProduto();
                    break;
                case 14:
                    operations.deleteProduto();
                    break;
                case 15:
                    operations.updateProduto();
                    break;
                case 16:
                    operations.listProduto();
                    break;
                case 17:
                    operations.addPedido();
                    break;
                case 18:
                    operations.deletePedido();
                    break;
                case 19:
                    operations.updatePedido();
                    break;
                case 20:
                    operations.listPedido();
                    break;
                case 21:
                    operations.listarPedidoCliente();
                    break;
                case 22:
                    operations.listarProdutoMaterial();
                    break;
                case 23:
                    operations.listarPedidoFuncionario();
                    break;
                case 24:
                    operations.listarPedidoProduto();
                    break;
                case 25:
                    operations.relatorioProdutoMediano();
                    break;
                case 26:
                    operations.relatorioPedidoMurilos();
                    break;
                case 27:
                    operations.relatorioPedidoPix();
                    break;
                case 28:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        operations.closeDriver(); // Close the driver after all operations
        scanner.close();
    }
}



//////////////////////////////////////////////MENU CRUD PARA CLIENTES 100% FUNCIONAL MAS SEM SEPARAÇAO DO ARQUIVO OPERATIONS
//////////////////////////////////////////////motivo da mudança: organização
/*
public class SEILATESTANDO {
    private static final String BOLT_URL = "bolt://localhost:7687";
    private static final String USERNAME = "neo4j";
    private static final String PASSWORD = "12344321";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Driver driver = GraphDatabase.driver(BOLT_URL, AuthTokens.basic(USERNAME, PASSWORD));

            try(Session session = driver.session()){
                boolean running = true;
    
                while (running) {
                    printMenu();
                    int choice = readChoice();

                    switch (choice) {
                        case 1:
                            addCliente(session);
                            break;
                        case 2:
                            deleteCliente(session);
                            break;
                        case 3:
                            updateCliente(session);
                            break;
                        case 4:
                            listCliente(session);
                            break;
                        case 5:
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
        } finally {
            driver.close();
        }

    }
    
    private static void printMenu() {
            System.out.println("MENU");
            System.out.println("1. Add Cliente");
            System.out.println("2. Delete Cliente");
            System.out.println("3. Update Cliente");
            System.out.println("4. List Clientes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
    }
    private static int readChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    //adicionar cliente input
    private static void addCliente(Session session) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter cliente: ");
            String cliente = scanner.nextLine();
            System.out.print("Enter telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Enter numero: ");
            String numero = scanner.nextLine();
            System.out.print("Enter clID: ");
            String clID = scanner.nextLine();
            System.out.print("Enter cep: ");
            String cep = scanner.nextLine();
            System.out.print("Enter rua: ");
            String rua = scanner.nextLine();

            // Create a new clienteBeanTest object with the user input
            clienteBeanTest clienteObject = new clienteBeanTest(cliente, telefone, numero, clID, cep, rua);   
            //Adicionando uma pessoa
            session.run("CREATE (cl:Cliente {cliente: $cliente, telefone: $telefone, numero: $numero, clID: $clID, cep: $cep, rua: $rua})",
                parameters("cliente", clienteObject.getCliente(), "telefone", clienteObject.getTelefone(),
                    "numero", clienteObject.getNumero(), "clID", clienteObject.getClID(), "cep", clienteObject.getCep(),
                    "rua", clienteObject.getRua()));
            System.out.println("Cliente added successfully!");
    }
    //deletar cliente input;
    private static void deleteCliente(Session session) {
        System.out.print("Enter clID of the cliente to delete: ");
        String clID = scanner.nextLine();

        // Execute the Cypher query to delete the cliente
        session.run("MATCH (cl:Cliente {clID: $clID}) OPTIONAL MATCH (cl)-[r1]-() DELETE r1, cl;",
                Values.parameters("clID", clID));

        System.out.println("Cliente deleted successfully!");
    }
    //update cliente input
    private static void updateCliente(Session session) {
        System.out.print("Enter clID to update: ");
        String clID = scanner.nextLine();

        System.out.print("Enter new cliente name: ");
        String clienteName = scanner.nextLine();

        // Rest of the code remains the same
        System.out.print("Enter new telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Enter new numero: ");
        String numero = scanner.nextLine();

        System.out.print("Enter new cep: ");
        String cep = scanner.nextLine();

        System.out.print("Enter new rua: ");
        String rua = scanner.nextLine();
        // Execute the Cypher query to update the cliente
        session.run("MATCH (cl:Cliente {clID: $clID}) SET cl.cliente = $cliente, cl.telefone = $telefone, cl.numero = $numero, cl.cep = $cep, cl.rua = $rua",
                Values.parameters("clID", clID, "cliente", clienteName, "telefone", telefone,
                        "numero", numero, "cep", cep,
                        "rua", rua));

        System.out.println("Cliente updated successfully!");
        }

    private static void listCliente(Session session) {
        // Execute the Cypher query to fetch all clientes
        Result result = session.run("MATCH (cl:Cliente) RETURN cl.cliente, toString(cl.telefone), toString(cl.numero), toString(cl.clID), toString(cl.cep), cl.rua");

        // Iterate over the result and print each cliente
        while (result.hasNext()) {
            Record record = result.next();
            String cliente = record.get(0).asString();
            String telefone = record.get(1).asString();
            String numero = record.get(2).asString();
            String clID = record.get(3).asString();
            String cep = record.get(4).asString();
            String rua = record.get(5).asString();

            clienteBeanTest clienteBean = new clienteBeanTest(cliente, telefone, numero, clID, cep, rua);
            System.out.println(clienteBean);
        }
    }
}
*/


























/*
INPUT ADICIONAR CLIENTE FINISHED
        
*/

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //  clienteBeanTest cliente = new clienteBeanTest ("nomeupdateteste2", "4788998888", "488", "26", "89244300", "kaja"); data test worthless for now

    /*
    ALL CRUD OPERATIONS THAT NEED INPUTS TO BE DONE
            //Listando
            Result result =  session.run("MATCH (cl:Cliente) RETURN cl.cliente, toString(cl.telefone), toString(cl.numero), toString(cl.clID), toString(cl.cep), cl.rua;");
                System.out.println(result.stream().map(record ->
                    new clienteBeanTest(record.get(0).asString(),
                    record.get(1).asString(),
                    record.get(2).asString(), record.get(3).asString(), record.get(4).asString(), record.get(5).asString()))
                    .collect(Collectors.toList())); 
            result.list().forEach(r -> System.out.println(r));
    */
    /*
            //Deletando
            session.run("MATCH (cl:Cliente {clID:$clID}) OPTIONAL MATCH (cl)-[r1]-() DELETE r1, cl;",
                parameters("cliente", cliente.getCliente(), "telefone", cliente.getTelefone(),
                        "numero", cliente.getNumero(), "clID", cliente.getClID(), "cep", cliente.getCep(),
                        "rua", cliente.getRua())); 
    */
    /*
           //Atualizando
            session.run("MATCH (cl:Cliente {cliente: $cliente}) SET cl.telefone = $telefone, cl.numero = $numero, cl.clID = $clID, cl.cep = $cep, cl.rua = $rua",
            Values.parameters("cliente", cliente.getCliente(), "telefone", cliente.getTelefone(),
                    "numero", cliente.getNumero(), "clID", cliente.getClID(), "cep", cliente.getCep(),
                    "rua", cliente.getRua()));
    */