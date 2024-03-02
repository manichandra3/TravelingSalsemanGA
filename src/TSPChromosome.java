import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TSPChromosome {
    private final List<TSPGene> chromosome;

    TSPChromosome(final List<TSPGene> chromosome) {
        this.chromosome = Collections.unmodifiableList(chromosome);
    }

    static TSPChromosome create(final TSPGene[] points) {
        final List<TSPGene> genes = Arrays.asList(Arrays.copyOf(points, points.length));
        Collections.shuffle(genes);
        return new TSPChromosome(genes);
    }

    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for(TSPGene gene : this.chromosome) {
            builder.append(gene.toString()).append(" : ");
        }
        return builder.toString();
    }

    public List<TSPGene> getChromosome() {
        return this.chromosome;
    }

    double calculateDistance() {
        double total = 0.0f;
        for(int i = 0; i < chromosome.size() - 1; i++) {
            total += this.chromosome.get(i).distance(this.chromosome.get(i+1));
        }
        return total;
    }

    TSPChromosome[] crossOver(final TSPChromosome other) {
        return null;
    }

    TSPChromosome mutate() {
        return null;
    }
}
