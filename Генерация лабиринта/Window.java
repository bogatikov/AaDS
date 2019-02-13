package manager.task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame {

    public Window() {
        super("Лабиринт");
        setSize(705, 520);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void drawLab() {
        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        final DrawingComponent dc = new DrawingComponent ();
        jcp.add(dc, BorderLayout.CENTER);
        JButton button = new JButton("Сгенерировать");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.getMattrix();
                dc.setNodes(main.nodes);
                repaint();
            }
        });
        jcp.add(button, BorderLayout.EAST);
    }

    class DrawingComponent extends JPanel {
        Node [][] nodes;
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D drp = (Graphics2D)g;
            int n = 10;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    drp.drawString(
                            nodes[i][j].x + ", " + nodes[i][j].y,
                            nodes[i][j].x * 50+10,
                            nodes[i][j].y*50+20
                    );
                    drp.drawOval(
                            nodes[i][j].x * 50+5,
                            nodes[i][j].y*50,
                            30,
                            30
                    );
                    if (nodes[i][j].next != null) {
                        drp.drawLine(
                                nodes[i][j].x*50+10,
                                nodes[i][j].y*50+20,
                                nodes[i][j].next.x*50+10,
                                nodes[i][j].next.y*50+20
                        );
                    }

                }
            }
        }

        public void setNodes(Node[][] nodes) {
            this.nodes = nodes;
        }
    }
}
