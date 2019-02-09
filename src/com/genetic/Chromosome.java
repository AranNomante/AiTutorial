package com.genetic;

import java.util.Arrays;

public class Chromosome {
    private boolean isFitnessChanged=true;
    private int[] genes;
    private int fitness = 0;

    Chromosome(int length) {
        genes = new int[length];
    }

    int[] getGenes() {
        isFitnessChanged=true;
        return genes;
    }

    int getFitness() {
        if(isFitnessChanged){
            fitness=recalculateFitness();
            isFitnessChanged=false;
        }
        return fitness;
    }

    @Override
    public String toString() {
        return "Chromosome{" +
                "genes=" + Arrays.toString(genes) +
                '}';
    }
    private int recalculateFitness(){
        int chromosomeFitness=0;
        for (int x = 0; x < genes.length; x++) {
            if(genes[x]==GeneticAlgorithm.TARGET_CHROMOSOME[x])chromosomeFitness++;
        }
        return chromosomeFitness;
    }
    Chromosome initializeChromosome() {
        for (int x = 0; x < genes.length; x++) {
            if (Math.random() >= 0.5) genes[x] = 1;
            else genes[x] = 0;
        }
        return this;
    }
}
