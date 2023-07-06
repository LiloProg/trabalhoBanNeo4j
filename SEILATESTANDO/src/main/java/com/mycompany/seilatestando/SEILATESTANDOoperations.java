/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import org.neo4j.driver.Value;
import static org.neo4j.driver.Values.parameters;
import org.neo4j.driver.types.Node;
/**
 *
 * @author Ryzen
 */
public class SEILATESTANDOoperations {
    private Driver driver;
    private Scanner scanner;

    public SEILATESTANDOoperations() {
        driver = GraphDatabase.driver("bolt://localhost:7687",
                AuthTokens.basic("neo4j", "12344321"));
        scanner = new Scanner(System.in);
    }
    //CLIENTE OPERATIONS
    public void addCliente() {
        try (Session session = driver.session()) {
            // Your addCliente logic goes here
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

            // Criar um clienteBeanTest com input do user.
            clienteBeanTest clienteObject = new clienteBeanTest(cliente, telefone, numero, clID, cep, rua);   
            //Adicionando uma pessoa
            session.run("CREATE (cl:Cliente {cliente: $cliente, telefone: $telefone, numero: $numero, clID: $clID, cep: $cep, rua: $rua})",
                parameters("cliente", clienteObject.getCliente(), "telefone", clienteObject.getTelefone(),
                    "numero", clienteObject.getNumero(), "clID", clienteObject.getClID(), "cep", clienteObject.getCep(),
                    "rua", clienteObject.getRua()));
            System.out.println("Cliente added successfully!");
        }
    }

    public void deleteCliente() {
        try (Session session = driver.session()) {
            
        System.out.print("Enter clID of the cliente to delete: ");
        String clID = scanner.nextLine();

        // Executar query do Cypher para deletar
        session.run("MATCH (cl:Cliente {clID: $clID}) OPTIONAL MATCH (cl)-[r1]-() DELETE r1, cl;",
                Values.parameters("clID", clID));

        System.out.println("Cliente deleted successfully!");
        } 
    }

    public void updateCliente() {
        try (Session session = driver.session()) {
            
        System.out.print("Enter clID to update: ");
        String clID = scanner.nextLine();

        System.out.print("Enter new cliente name: ");
        String clienteName = scanner.nextLine();

        
        System.out.print("Enter new telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Enter new numero: ");
        String numero = scanner.nextLine();

        System.out.print("Enter new cep: ");
        String cep = scanner.nextLine();

        System.out.print("Enter new rua: ");
        String rua = scanner.nextLine();
        // Executar Query Cypher para dar update
        session.run("MATCH (cl:Cliente {clID: $clID}) SET cl.cliente = $cliente, cl.telefone = $telefone, cl.numero = $numero, cl.cep = $cep, cl.rua = $rua",
                Values.parameters("clID", clID, "cliente", clienteName, "telefone", telefone,
                        "numero", numero, "cep", cep,
                        "rua", rua));

        System.out.println("Cliente updated successfully!");
        }
    }

    public void listCliente() {
        try (Session session = driver.session()) {
            
        //Executar query do cypher para pegar os clientes
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
    
    //FUNCIONARIO OPERATIONS**********************************************************************************************************************************************************************************************************************************************
    //ADD FUNCIONARIO
    public void addFuncionario() {
        try (Session session = driver.session()) {
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter funcionario: ");
            String funcionario = scanner.nextLine();
            System.out.print("Enter fuID: ");
            String fuID = scanner.nextLine();
            System.out.print("Enter telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Enter salario: ");
            String salario = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
 

            
            funcionarioBeanTest funcionarioObject = new funcionarioBeanTest(funcionario, fuID, telefone, salario, email);   
            //Adicionando uma pessoa
            session.run("CREATE (fu:Funcionario {funcionario: $funcionario, fuID: $fuID, telefone: $telefone, salario: $salario, email: $email})",
                parameters("funcionario", funcionarioObject.getFuncionario(), "fuID", funcionarioObject.getFuID(),
                    "telefone", funcionarioObject.getTelefone(), "salario", funcionarioObject.getSalario(), "email",
                    funcionarioObject.getEmail()));
            System.out.println("Funcionario added successfully!");
        }
    }
    //DELETE FUNCIONARIO
    public void deleteFuncionario() {
        try (Session session = driver.session()) {
            // Your deleteFuncionario logic goes here
            System.out.print("Enter fuID of the funcionario to delete: ");
            String fuID = scanner.nextLine();

            // Execute the Cypher query to delete the funcionario
            session.run("MATCH (fu:Funcionario {fuID: $fuID}) OPTIONAL MATCH (fu)-[r1]-() DELETE r1, fu;",
                    Values.parameters("fuID", fuID));

            System.out.println("Funcionario deleted successfully!");
        }
    }
    //UPDATE FUNCIONARIO
    public void updateFuncionario() {
        try (Session session = driver.session()) {
           
            System.out.print("Enter fuID to update: ");
            String fuID = scanner.nextLine();

            System.out.print("Enter new funcionario name: ");
            String funcionarioName = scanner.nextLine();

            
            System.out.print("Enter new telefone: ");
            String telefone = scanner.nextLine();

            System.out.print("Enter new salario: ");
            String salario = scanner.nextLine();

            System.out.print("Enter new email: ");
            String email = scanner.nextLine();

            
            session.run("MATCH (fu:Funcionario {fuID: $fuID}) SET fu.funcionario = $funcionario, fu.telefone = $telefone, fu.salario = $salario, fu.email = $email",
                    Values.parameters("fuID", fuID, "funcionario", funcionarioName, "telefone", telefone,
                            "salario", salario, "email", email));

            System.out.println("Funcionario updated successfully!");
        } 
    }
    //LIST FUNCIONARIO
    public void listFuncionario() {
        try (Session session = driver.session()) {

            Result result = session.run("MATCH (fu:Funcionario) RETURN fu.funcionario, fu.fuID, toString(fu.telefone), toString(fu.salario), fu.email");

            
            while (result.hasNext()) {
                Record record = result.next();
                String funcionario = record.get(0).asString();
                String fuID = record.get(1).asString();
                String telefone = record.get(2).asString();
                String salario = record.get(3).asString();
                String email = record.get(4).asString();

                funcionarioBeanTest funcionarioBean = new funcionarioBeanTest(funcionario, fuID, telefone, salario, email);
                System.out.println(funcionarioBean);
            }
        } 
    }
    //MATERIAL OPERATIONS**********************************************************************************************************************************************************************************************************************************************************
    public void addMaterial() {
        try (Session session = driver.session()) {
            // 
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter material: ");
            String material = scanner.nextLine();
            System.out.print("Enter maID: ");
            String maID = scanner.nextLine();
            System.out.print("Enter estoque: ");
            String estoque = scanner.nextLine();
            System.out.print("Enter qualidade: ");
            String qualidade = scanner.nextLine();

            // 
            materialBeanTest materialObject = new materialBeanTest(material, maID, estoque, qualidade);   
            //
            session.run("CREATE (ma:Material {material: $material, maID: $maID, estoque: $estoque, qualidade: $qualidade})",
                parameters("material", materialObject.getMaterial(), "maID", materialObject.getMaID(),
                    "estoque", materialObject.getEstoque(), "qualidade", materialObject.getQualidade()));
            System.out.println("Material added successfully!");
        }
    }  
    //DELETE MATERIAL
    public void deleteMaterial() {
        try (Session session = driver.session()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter maID of the material to delete: ");
            String maID = scanner.nextLine();

            session.run("MATCH (ma:Material {maID: $maID}) OPTIONAL MATCH (ma)-[r1]-() DELETE r1, ma;",
                    Values.parameters("maID", maID));

            System.out.println("Material deleted successfully!");
        }
    }
    //UPDATE MATERIAL
    public void updateMaterial() {
        try (Session session = driver.session()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter maID to update: ");
            String maID = scanner.nextLine();

            System.out.print("Enter new material name: ");
            String material = scanner.nextLine();

            System.out.print("Enter new estoque: ");
            String estoque = scanner.nextLine();

            System.out.print("Enter new qualidade: ");
            String qualidade = scanner.nextLine();

            session.run("MATCH (ma:Material {maID: $maID}) SET ma.material = $material, ma.estoque = $estoque, ma.qualidade = $qualidade",
                    Values.parameters("maID", maID, "material", material, "estoque", estoque, "qualidade", qualidade));

            System.out.println("Material updated successfully!");
        }
    }
    //LIST MATERIAL
    public void listMaterial() {
        try (Session session = driver.session()) {
            Result result = session.run("MATCH (ma:Material) RETURN ma.material, ma.maID, ma.estoque, ma.qualidade");

            while (result.hasNext()) {
                Record record = result.next();
                String material = record.get(0).asString();
                String maID = record.get(1).asString();
                String estoque = record.get(2).asString();
                String qualidade = record.get(3).asString();

                materialBeanTest materialBean = new materialBeanTest(material, maID, estoque, qualidade);
                System.out.println(materialBean);
            }
        }
    }
    //PRODUTO OPERATIONS*********************************************************************************************************************************************************************************************************************************************************************************************************************************************
    public void addProduto() {
        try (Session session = driver.session()) {
            // 
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter produto: ");
            String produto = scanner.nextLine();
            System.out.print("Enter prID: ");
            String prID = scanner.nextLine();
            System.out.print("Enter materialId: ");
            String materialId = scanner.nextLine();
            System.out.print("Enter preco: ");
            String preco = scanner.nextLine();
            System.out.print("Enter estoque: ");
            String estoque = scanner.nextLine();
            System.out.print("Enter tamanho: ");
            String tamanho = scanner.nextLine();
            // 
            produtoBeanTest produtoObject = new produtoBeanTest(produto, prID, materialId, preco, estoque, tamanho);   
            //
            session.run("CREATE (pr:Produto {produto: $produto, prID: $prID, material: $materialId, preco: $preco, estoque: $estoque, tamanho: $tamanho})",
                parameters("produto", produtoObject.getProduto(), "prID", produtoObject.getPrID(),
                    "materialId", produtoObject.getMaterialId(), "preco", produtoObject.getPreco(), "estoque", 
                    produtoObject.getEstoque(), "tamanho", produtoObject.getTamanho()));
            System.out.println("Produto added successfully!");
        }
    }
    //DELETE PRODUTO
    public void deleteProduto() {
        try (Session session = driver.session()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter prID of the produto to delete: ");
            String prID = scanner.nextLine();

            session.run("MATCH (pr:Produto {prID: $prID}) OPTIONAL MATCH (pr)-[r1]-() DELETE r1, pr;",
                    Values.parameters("prID", prID));

            System.out.println("Produto deleted successfully!");
        }
    }
    //UPDATE PRODUTO
    public void updateProduto() {
        try (Session session = driver.session()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter prID to update: ");
            String prID = scanner.nextLine();

            System.out.print("Enter new produto name: ");
            String produto = scanner.nextLine();

            System.out.print("Enter new materialId: ");
            String materialId = scanner.nextLine();

            System.out.print("Enter new preco: ");
            String preco = scanner.nextLine();

            System.out.print("Enter new estoque: ");
            String estoque = scanner.nextLine();

            System.out.print("Enter new tamanho: ");
            String tamanho = scanner.nextLine();

            session.run("MATCH (pr:Produto {prID: $prID}) SET pr.produto = $produto, pr.material = $materialId, pr.preco = $preco, pr.estoque = $estoque, pr.tamanho = $tamanho",
                    Values.parameters("prID", prID, "produto", produto, "materialId", materialId, "preco", preco, "estoque", estoque, "tamanho", tamanho));

            System.out.println("Produto updated successfully!");
        }
    }
    //LIST PRODUTO
    public void listProduto() {
        try (Session session = driver.session()) {
            Result result = session.run("MATCH (pr:Produto) RETURN pr.produto, pr.prID, pr.material, pr.preco, pr.estoque, pr.tamanho");

            while (result.hasNext()) {
                Record record = result.next();
                String produto = record.get(0).asString();
                String prID = record.get(1).asString();
                String materialId = record.get(2).asString();
                String preco = record.get(3).asString();
                String estoque = record.get(4).asString();
                String tamanho = record.get(5).asString();

                produtoBeanTest produtoBean = new produtoBeanTest(produto, prID, materialId, preco, estoque, tamanho);
                System.out.println(produtoBean);
            }
        }
    }
    //PEDIDO OPERATIONS********************************************************************************************************************************************************************************************************************************************************************************************************** 
    public void addPedido() {
        try (Session session = driver.session()) {
            // 
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter pedidoId: ");
            String peID = scanner.nextLine();
            System.out.print("Enter clienteId: ");
            String clienteId = scanner.nextLine();
            System.out.print("Enter funcionarioId: ");
            String funcionarioId = scanner.nextLine();
            System.out.print("Enter produtoId: ");
            String produtoId = scanner.nextLine();
            System.out.print("Enter precoPed: ");
            String precoPed = scanner.nextLine();
            System.out.print("Enter metdPagamento: ");
            String metdPagamento = scanner.nextLine();
            // 
            pedidoBeanTest pedidoObject = new pedidoBeanTest(peID, clienteId, funcionarioId, produtoId, precoPed, metdPagamento );   
            //
            session.run("CREATE (pe:Pedido {peID: $peID, cliente: $clienteId, funcionario: $funcionarioId, produto: $produtoId, preco: $precoPed, metdpagamento: $metdPagamento})",
                parameters("peID", pedidoObject.getPeID(), "clienteId", pedidoObject.getClienteId(),
                    "funcionarioId", pedidoObject.getFuncionarioId(), "produtoId", pedidoObject.getProdutoId(), "precoPed", 
                    pedidoObject.getPrecoPed(), "metdPagamento", pedidoObject.getMetdPagamento()));
            
            // Criaçao do relacionamento entre Pedido e Cliente.
            session.run("MATCH (pe:Pedido {peID: $peID}), (cl:Cliente {clID: $clienteId}) CREATE (pe)-[:PEDIDO_DO_CLIENTE]->(cl)",
                parameters("peID", pedidoObject.getPeID(), "clienteId", pedidoObject.getClienteId()));
            
            // Criação do relacionamento entre Pedido e Funcionário
            session.run("MATCH (pe:Pedido {peID: $peID}), (fu:Funcionario {fuID: $funcionarioId}) CREATE (pe)-[:PEDIDO_DO_FUNCIONARIO]->(fu)",
                parameters("peID", pedidoObject.getPeID(), "funcionarioId", pedidoObject.getFuncionarioId()));

            // Criação do relacionamento entre Pedido e Produto
            session.run("MATCH (pe:Pedido {peID: $peID}), (pr:Produto {prID: $produtoId}) CREATE (pe)-[:PEDIDO_DO_PRODUTO]->(pr)",
                    parameters("peID", pedidoObject.getPeID(), "produtoId", pedidoObject.getProdutoId()));

            
            System.out.println("Pedido added successfully!");
        }
    }
    //DELET PEDIDO
    public void deletePedido() {
        try (Session session = driver.session()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter pedidoId of the pedido to delete: ");
            String peID = scanner.nextLine();

            session.run("MATCH (pe:Pedido {peID: $peID}) OPTIONAL MATCH (pe)-[r1]-() DELETE r1, pe;",
                    Values.parameters("peID", peID));

            System.out.println("Pedido deleted successfully!");
        }
    }
    //UPDATE PEDIDO
    public void updatePedido() {
        try (Session session = driver.session()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter pedidoId of the pedido to update: ");
            String peID = scanner.nextLine();

            System.out.print("Enter new clienteId: ");
            String newClienteId = scanner.nextLine();
            System.out.print("Enter new funcionarioId: ");
            String newFuncionarioId = scanner.nextLine();
            System.out.print("Enter new produtoId: ");
            String newProdutoId = scanner.nextLine();
            System.out.print("Enter new precoPed: ");
            String newPrecoPed = scanner.nextLine();
            System.out.print("Enter new metdPagamento: ");
            String newMetdPagamento = scanner.nextLine();

            session.run("MATCH (pe:Pedido {peID: $peID}) SET pe.cliente = $newClienteId, pe.funcionario = $newFuncionarioId, pe.produto = $newProdutoId, pe.precoPed = $newPrecoPed, pe.metdpagamento = $newMetdPagamento",
                    Values.parameters("peID", peID, "newClienteId", newClienteId, "newFuncionarioId", newFuncionarioId, "newProdutoId", newProdutoId, "newPrecoPed", newPrecoPed, "newMetdPagamento", newMetdPagamento));

            System.out.println("Pedido updated successfully!");
        }
    
    }
    //LIST PEDIDO MATCH (pe:Pedido) RETURN pe.peID, pe.cliete, pe.funcionario, pe.produto, pe.preco, pe.metdpagamento
    public void listPedido() {
        try (Session session = driver.session()) {
            Result result = session.run("MATCH (pe:Pedido) RETURN pe.peID, pe.cliente, pe.funcionario, pe.produto, pe.preco, pe.metdpagamento");

            System.out.println("List of Pedidos:");
            while (result.hasNext()) {
                Record record = result.next();
                String peID = record.get("pe.peID").asString();
                String clienteId = record.get("pe.cliente").asString();
                String funcionarioId = record.get("pe.funcionario").asString();
                String produtoId = record.get("pe.produto").asString();
                String precoPed = record.get("pe.preco").asString();
                String metdPagamento = record.get("pe.metdpagamento").asString();

                System.out.println("Pedido ID: " + peID);
                System.out.println("Cliente ID: " + clienteId);
                System.out.println("Funcionario ID: " + funcionarioId);
                System.out.println("Produto ID: " + produtoId);
                System.out.println("Preco: " + precoPed);
                System.out.println("Metodo de Pagamento: " + metdPagamento);
                System.out.println("--------------------------------------");
            }
        }
    }
    //RELATORIOS e RELACIONAMENTOS********************************************************************************************************************************************************************************************************************************************
    //RELATORIOS e RELACIONAMENTOS************************************************************************************************************************************************************************************************
    //RELATORIOS e RELACIONAMENTOS****************************************************************************************************************************************************************************************************************************
    //LISTA CODIGO DO PEDIDO E O CODIGO DO RESPECTIVO CLIENTE
    public void listarPedidoCliente() {
        try (Session session = driver.session()) {
            Result result = session.run("MATCH (pe:Pedido)-[:PEDIDO_DO_CLIENTE]->(cl:Cliente) RETURN pe, cl");

            System.out.println("List of Pedidos and Clientes:");
            while (result.hasNext()) {
                Record record = result.next();
                Node pedidoNode = record.get("pe").asNode();
                Node clienteNode = record.get("cl").asNode();

                System.out.println("Pedido----");
                pedidoNode.keys().forEach(key -> {
                    System.out.println(key + ": " + pedidoNode.get(key).asString());
                });

                System.out.println("Cliente----");
                clienteNode.keys().forEach(key -> {
                    System.out.println(key + ": " + clienteNode.get(key).asString());
                });

                System.out.println("--------------------------------------");
            }
        }
    }   

    //LISTA PEDIDO E MATERIAL
    public void listarProdutoMaterial() {
        try (Session session = driver.session()) {
            Result result = session.run("MATCH (pr:Produto)-[:PRODUTO_DE_MATERIAL]->(ma:Material) RETURN pr, ma");

            System.out.println("List of Produtos and Materiais:");
            while (result.hasNext()) {
                Record record = result.next();
                Node produtoNode = record.get("pr").asNode();
                Node materialNode = record.get("ma").asNode();

                System.out.println("Produto----");
                produtoNode.keys().forEach(key -> {
                    System.out.println(key + ": " + produtoNode.get(key).asString());
                });

                System.out.println("Material----");
                materialNode.keys().forEach(key -> {
                    System.out.println(key + ": " + materialNode.get(key).asString());
                });

                System.out.println("--------------------------------------");
            }
        }
    }
    //LISTA PEDIDO E FUNCIONARIO
    public void listarPedidoFuncionario() {
        try (Session session = driver.session()) {
            Result result = session.run("MATCH (pe:Pedido)-[:PEDIDO_DO_FUNCIONARIO]->(fu:Funcionario) RETURN pe, fu");

            System.out.println("List of Pedidos and Funcionarios:");
            while (result.hasNext()) {
                Record record = result.next();
                Node pedidoNode = record.get("pe").asNode();
                Node funcionarioNode = record.get("fu").asNode();

                System.out.println("Pedido----");
                pedidoNode.keys().forEach(key -> {
                    System.out.println(key + ": " + pedidoNode.get(key).asString());
                });

                System.out.println("Funcionario----");
                funcionarioNode.keys().forEach(key -> {
                    System.out.println(key + ": " + funcionarioNode.get(key).asString());
                });

                System.out.println("--------------------------------------");
            }
        }
    }
    //LISTA PEDIDO E PRODUTO
    public void listarPedidoProduto() {
        try (Session session = driver.session()) {
            Result result = session.run("MATCH (pe:Pedido)-[:PEDIDO_DO_PRODUTO]->(pr:Produto) RETURN pe, pr");

            System.out.println("List of Pedidos and Produtos:");
            while (result.hasNext()) {
                Record record = result.next();
                Node pedidoNode = record.get("pe").asNode();
                Node produtoNode = record.get("pr").asNode();

                System.out.println("Pedido----");
                pedidoNode.keys().forEach(key -> {
                    System.out.println(key + ": " + pedidoNode.get(key).asString());
                });

                System.out.println("Produto----");
                produtoNode.keys().forEach(key -> {
                    System.out.println(key + ": " + produtoNode.get(key).asString());
                });

                System.out.println("--------------------------------------");
            }
        }
    }   


    //RELATORIOS**********************************************************************************************************************************************************************************************************************************************************************************************************
    //RELATORIOS**********************************************************************************************************************************************************************************
    //RELATORIOS**********************************************************************************************************************************************************************************
    public void relatorioProdutoMediano() {
        try (Session session = driver.session()) {
            Result result = session.run("MATCH (pr:Produto)-[:PRODUTO_DE_MATERIAL]->(ma:Material) WHERE ma.qualidade = 'mediano' RETURN pr.prID, ma.maID, ma.qualidade");

            System.out.println("Relatório de Produtos Médianos:");
            while (result.hasNext()) {
                Record record = result.next();
                String prID = record.get(0).asString();
                String maID = record.get(1).asString();
                String qualidade = record.get(2).asString();

                System.out.println("prID: " + prID);
                System.out.println("maID: " + maID);
                System.out.println("Qualidade: " + qualidade);
                System.out.println("--------------------------------------");
            }
        }
    }
    
    public void relatorioPedidoMurilos() {
        try (Session session = driver.session()) {
            Result result = session.run("MATCH (pe:Pedido)-[:PEDIDO_DO_CLIENTE]->(cl:Cliente) WHERE cl.cliente = 'murilo' RETURN pe.peID, cl.clID, cl.cliente");

            System.out.println("Relatório de Pedidos do Cliente 'murilo':");
            while (result.hasNext()) {
                Record record = result.next();
                String peID = record.get(0).asString();
                String clID = record.get(1).asString();
                String cliente = record.get(2).asString();

                System.out.println("peID: " + peID);
                System.out.println("clID: " + clID);
                System.out.println("Cliente: " + cliente);
                System.out.println("--------------------------------------");
            }
        }
    }
    
    public void relatorioPedidoPix() {
    try (Session session = driver.session()) {
        Result result = session.run("MATCH (pe:Pedido) WHERE pe.metdpagamento = 'pix' RETURN pe.peID, pe.metdpagamento");

        System.out.println("Relatório de Pedidos com Pagamento via PIX:");
        while (result.hasNext()) {
            Record record = result.next();
            String peID = record.get(0).asString();
            String metdPagamento = record.get(1).asString();

            System.out.println("peID: " + peID);
            System.out.println("Método de Pagamento: " + metdPagamento);
            System.out.println("--------------------------------------");
        }
    }
}
    
    
    
    //close driver******************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
