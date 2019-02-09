package com.genetic;

import java.util.Arrays;

class Population {
    private Chromosome[] chromosomes;

    Population(int length) {
        chromosomes = new Chromosome[length];
    }

    Chromosome[] getChromosomes() {
        return chromosomes;
    }

    Population initializePopulation() {
        for (int x = 0; x < chromosomes.length; x++) {
            chromosomes[x] =
                    new Chromosome(GeneticAlgorithm.TARGET_CHROMOSOME.length).initializeChromosome();
        }
        sortChromosomeByFitness();
        return this;
    }

    void sortChromosomeByFitness() {
        Arrays.sort(chromosomes,(chromosome1,chromosome2)->{
            int flag=0;
            if(chromosome1.getFitness()>chromosome2.getFitness())flag=-1;
            else if(chromosome1.getFitness()<chromosome2.getFitness())flag=1;
            return flag;
        });
    }
}
