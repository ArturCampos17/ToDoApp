import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return (concluida ? "[X] " : "[ ] ") + descricao;
    }
}

public class ToDoApp {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarTarefa(scanner);
                case 2 -> listarTarefas();
                case 3 -> concluirTarefa(scanner);
                case 4 -> removerTarefa(scanner);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- Lista de Tarefas ---");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Listar tarefas");
        System.out.println("3. Marcar tarefa como concluída");
        System.out.println("4. Remover tarefa");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarTarefa(Scanner scanner) {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        tarefas.add(new Tarefa(descricao));
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            System.out.println("\n--- Tarefas ---");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    private static void concluirTarefa(Scanner scanner) {
        listarTarefas();
        if (!tarefas.isEmpty()) {
            System.out.print("Digite o número da tarefa a ser concluída: ");
            int numero = scanner.nextInt();
            if (numero > 0 && numero <= tarefas.size()) {
                tarefas.get(numero - 1).concluir();
                System.out.println("Tarefa marcada como concluída!");
            } else {
                System.out.println("Número inválido.");
            }
        }
    }

    private static void removerTarefa(Scanner scanner) {
        listarTarefas();
        if (!tarefas.isEmpty()) {
            System.out.print("Digite o número da tarefa a ser removida: ");
            int numero = scanner.nextInt();
            if (numero > 0 && numero <= tarefas.size()) {
                tarefas.remove(numero - 1);
                System.out.println("Tarefa removida com sucesso!");
            } else {
                System.out.println("Número inválido.");
            }
        }
    }
}
