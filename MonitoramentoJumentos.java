// Fabio Alves de Oliveira - 325127623

import java.util.Scanner;

public class MonitoramentoJumentos {

    public static void main(String[] args) {

        int populacaoInicial = 1400000;
        int populacaoAtual = 84000;
        int abatesAnuais = 50000;

        // Exibe os dados iniciais
        double taxaReducao = calcularTaxaReducao(populacaoInicial, populacaoAtual);
        System.out.println("=== SISTEMA DE MONITORAMENTO DOS JUMENTOS NORDESTINOS ===");
        System.out.println("População inicial: " + populacaoInicial);
        System.out.println("População atual: " + populacaoAtual);
        System.out.println("Abates anuais: " + abatesAnuais);
        System.out.printf("\nTaxa de redução histórica: %.2f%%\n", taxaReducao);

        // Verifica se espécie está em risco crítico
        if (estaEmRiscoCritico(taxaReducao)) {
            System.out.println("[ALERTA] Espécie em RISCO CRÍTICO!");
        } else {
            System.out.println("[Status] Espécie em risco moderado.");
        }

        // Solicita o número de anos para a simulação
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nQuantos anos você quer simular para ver o impacto dos abates? (Ex: 1, 3, 5): ");
        int anosSimulados = scanner.nextInt();

        // Simula o impacto dos abates
        int populacaoRestante = simularImpactoAbate(populacaoAtual, abatesAnuais, anosSimulados);

        // Exibe o resultado da simulação
        exibirDeclaracaoFinal(populacaoRestante, anosSimulados);

        scanner.close();
    }

    // Cálculo da taxa de redução da população
    public static double calcularTaxaReducao(int populacaoInicial, int populacaoAtual) {
        return (1 - (double) populacaoAtual / populacaoInicial) * 100;  // Retorna a taax de redução em %
    }

    // Verificação de risco crítico
    public static boolean estaEmRiscoCritico(double taxaReducao) {
        return taxaReducao >= 90;  // Se a taxa de redução for 90% ou mais, está em risco critico
    }

    // Simulação de impacto dos abates
    public static int simularImpactoAbate(int populacaoAtual, int abatesAnuais, int anosSimulados) {
        return populacaoAtual - (abatesAnuais * anosSimulados);  // Calcula a população restante após abates anuais
    }

    // Exibe o resultaado final da simulaçoa
    public static void exibirDeclaracaoFinal(int populacaoRestante, int anos) {
        if (populacaoRestante <= 0) {
            System.out.println("ALERTA! A população de jumentos está extinta após " + anos + " anos.");
        } else {
            System.out.println("--- SIMULAÇÃO FINAL ---");
            System.out.println("População restante após " + anos + " anos: " + populacaoRestante + " jumentos.");
            System.out.println("Ainda há esperança! Iniciativas de conservação são vitais.");
        }
        System.out.println("Programa finalizado.");
    }
}
