// Genetic algorithms (GAs) are optimization techniques inspired by natural selection and genetics.
// They begin by initializing a population of potential solutions represented as chromosomes.
// Through processes like selection, crossover (recombination),
// and mutation, the algorithm evolves the population over generations.
// Selection favors individuals with higher fitness, mirroring the concept of survival of the fittest.
// Crossover involves exchanging genetic information between selected individuals,
// and mutation introduces random changes for diversity.
// The algorithm iteratively refines the population until a termination criterion is met.
// GA's are versatile and find applications in solving complex optimization problems across various domains,
// with parameters like population size and mutation rate influencing their effectiveness.

// The Traveling Salesman Problem (TSP)
// involves finding the shortest possible tour that visits each city exactly once and returns to the starting city.
// The objective is to minimize the total distance traveled along the tour.
// It is represented mathematically with binary decision variables and constraints
// ensuring that each city is visited and left exactly once.
// The TSP is NP-hard,
// and various algorithms, such as heuristics and meta heuristics,
// are employed to find near-optimal solutions for practical instances.


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicInteger;

public class World extends JPanel {
    private final AtomicInteger generation;

    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    private World() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        this.generation = new AtomicInteger(0);
        final Timer timer  = new Timer(5, (ActionEvent e) -> {
            repaint();
        });
        timer.start();
    }

    @Override
    public void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        final Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.CYAN);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawString("gen: " + this.generation.incrementAndGet(), 350, 15);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
           final JFrame frame = new JFrame();
           frame.setTitle("Genetic Algorithms");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.add(new World(), BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });

    }
}