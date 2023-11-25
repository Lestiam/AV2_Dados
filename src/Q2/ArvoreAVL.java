package Q2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static javax.swing.Spring.height;

public class ArvoreAVL {
    public class DadosNode {
        private int cod;
        private String descricao;

        public DadosNode(int cod, String descricao) {
            this.cod = cod;
            this.descricao = descricao;
        }

        public int getCod() {
            return cod;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public class Node {
        private Node left, right, parent;
        private int height = 1;
        private DadosNode data;

        private Node(DadosNode data) {
            this.data = data;
        }
    }

    // Restante do código...

    private Node insert(Node node, DadosNode data) {
        // Mesma lógica, apenas ajustando para comparar o atributo "cod"
        if (node == null) {
            return (new Node(data));
        }

        if (data.getCod() < node.data.getCod())
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);

        // Atualiza a altura
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Obtém o fator de equilíbrio
        int balance = getBalance(node);

        // Casos de desequilíbrio...

        return node;
    }

    // Métodos de caminhamento ajustados para imprimir código e descrição
    public void preOrder(Node root) {
        if (root != null) {
            preOrder(root.left);
            System.out.printf("%d - %s%n", root.data.getCod(), root.data.getDescricao());
            preOrder(root.right);
        }
    }

    // Métodos restantes ajustados conforme necessário...

    public static void main(String[] args) {
        ArvoreAVL tree = new ArvoreAVL();
        Node root = null;

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("<1> Inserir");
            System.out.println("<2> Excluir");
            System.out.println("<3> Pesquisar");
            System.out.println("<4> Caminhamento em pré-ordem");
            System.out.println("<5> Sair");
            System.out.print("Escolha uma opção: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Inserir dados
                    System.out.print("Digite o código: ");
                    int cod = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha
                    System.out.print("Digite a descrição: ");
                    String descricao = scanner.nextLine();
                    DadosNode data = new DadosNode(cod, descricao);
                    root = tree.insert(root, data);
                    System.out.println("Dados inseridos com sucesso!");
                    System.out.println("Árvore atual:");
                    tree.print(root);
                    break;

                // Restante do código...

            }
        } while (choice != 5);

        scanner.close();
    }
}
