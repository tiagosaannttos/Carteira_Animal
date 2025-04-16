package View;

import Controller.AnimalController;
import Controller.TutorController;
import Controller.HistoricoController;
import model.Animal;
import model.Tutor;
import model.Historico;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AnimalController animalController = new AnimalController();
        TutorController tutorController = new TutorController();
        HistoricoController historicoController = new HistoricoController();

        int opcao;

        do {
            // Exibe o menu de opções
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Animal");
            System.out.println("2 - Cadastrar Tutor");
            System.out.println("3 - Cadastrar Histórico");
            System.out.println("4 - Listar Animais");
            System.out.println("5 - Listar Tutores");
            System.out.println("6 - Listar Histórico");
            System.out.println("7 - Excluir Animal");
            System.out.println("8 - Excluir Tutor");
            System.out.println("9 - Excluir Histórico");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1: // Cadastrar Animal
                    System.out.print("Nome do Animal: ");
                    String nomeAnimal = sc.nextLine();
                    System.out.print("Espécie: ");
                    String especie = sc.nextLine();
                    System.out.print("Raça: ");
                    String raca = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine(); // Limpa o buffer
                    System.out.print("Cor: ");
                    String cor = sc.nextLine(); // Novo campo
                    System.out.print("Sexo: ");
                    String sexo = sc.nextLine(); // Novo campo
                    System.out.print("Peso: ");
                    double peso = sc.nextDouble(); // Novo campo
                    sc.nextLine(); // Limpa o buffer

                    // Lista os tutores para o usuário escolher
                    System.out.println("Escolha o Tutor para o Animal:");
                    tutorController.listarTutores();
                    System.out.print("Escolha o ID do Tutor: ");
                    int idTutor = sc.nextInt();
                    sc.nextLine(); // Limpa o buffer

                    // Verifica se o ID do Tutor é válido (você pode adicionar lógica para garantir isso)
                    Animal animal = new Animal(0, nomeAnimal, especie, raca, idade, idTutor, cor, sexo, peso);
                    animalController.cadastrarAnimal(animal);
                    break;

                case 2: // Cadastrar Tutor
                    System.out.print("Nome do Tutor: ");
                    String nomeTutor = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();  // Novo campo
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();    // Novo campo

                    // O ID será gerado automaticamente pelo banco de dados
                    Tutor tutor = new Tutor(0, nomeTutor, telefone, endereco, email, cpf);
                    tutorController.cadastrarTutor(tutor);
                    break;

                case 3: // Cadastrar Histórico
                    System.out.print("ID do Animal: ");
                    int idAnimal = sc.nextInt();
                    sc.nextLine(); // Limpa o buffer
                    System.out.print("Descrição do Histórico: ");
                    String descricao = sc.nextLine();
                    System.out.print("Data do Histórico: ");
                    String data = sc.nextLine();

                    Historico historico = new Historico(0, descricao, data, idAnimal);
                    historicoController.cadastrarHistorico(historico);
                    break;

                case 4: // Listar Animais
                    animalController.listarAnimais();
                    break;

                case 5: // Listar Tutores
                    tutorController.listarTutores();
                    break;

                case 6: // Listar Histórico
                    historicoController.listarHistorico();
                    break;

                case 7: // Excluir Animal
                    System.out.print("ID do Animal a excluir: ");
                    int idExcluirAnimal = sc.nextInt();
                    animalController.excluirAnimal(idExcluirAnimal);
                    break;

                case 8: // Excluir Tutor
                    System.out.print("ID do Tutor a excluir: ");
                    int idExcluirTutor = sc.nextInt();
                    tutorController.excluirTutor(idExcluirTutor);
                    break;

                case 9: // Excluir Histórico
                    System.out.print("ID do Histórico a excluir: ");
                    int idExcluirHistorico = sc.nextInt();
                    historicoController.excluirHistorico(idExcluirHistorico);
                    break;

                case 0: // Sair
                    System.out.println("Encerrando...");
                    break;

                default: // Opção inválida
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
