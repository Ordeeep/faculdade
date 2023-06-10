import org.jfugue.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PianoInterface extends JFrame implements ActionListener {
    private JButton[] pianoKeys;
    private Player player;
    private Map<String, Integer> noteDurations;
    private String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    public PianoInterface() {
        setTitle("Piano");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel pianoPanel = new JPanel();
        pianoPanel.setLayout(new GridLayout(1, 0));

        pianoKeys = new JButton[12];

        for (int i = 0; i < pianoKeys.length; i++) {
            pianoKeys[i] = new JButton(notes[i]);
            pianoKeys[i].setPreferredSize(new Dimension(50, 120));
            pianoKeys[i].addActionListener(this);
            pianoPanel.add(pianoKeys[i]);
        }

        JPanel playPanel = new JPanel();
        playPanel.setLayout(new FlowLayout());

        JButton playButton1 = new JButton("Play");
        playButton1.setPreferredSize(new Dimension(80, 40));
        playButton1.addActionListener(this);
        playPanel.add(playButton1);

        JButton playButton2 = new JButton("Play 2");
        playButton2.setPreferredSize(new Dimension(80, 40));
        playButton2.addActionListener(this);
        playPanel.add(playButton2);

        JButton playButton3 = new JButton("Play 3");
        playButton3.setPreferredSize(new Dimension(80, 40));
        playButton3.addActionListener(this);
        playPanel.add(playButton3);

        contentPane.add(playPanel, BorderLayout.NORTH);
        contentPane.add(pianoPanel, BorderLayout.CENTER);

        noteDurations = new HashMap<>();
        noteDurations.put("C", 200);
        noteDurations.put("C#", 200);
        noteDurations.put("D", 200);
        noteDurations.put("D#", 200);
        noteDurations.put("E", 200);
        noteDurations.put("F", 200);
        noteDurations.put("F#", 200);
        noteDurations.put("G", 200);
        noteDurations.put("G#", 200);
        noteDurations.put("A", 200);
        noteDurations.put("A#", 200);
        noteDurations.put("B", 200);

        player = new Player();
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Play")) {
                String musicString = "C D E F G A B C D E F G A B C D E F G A B";
                playMusicWithColorThread(musicString);
            } else if (button.getText().equals("Play 2")) {
                String musicString = "C# D# F F# G# A# C# D# F F# G# A# C# D# F F# G# A#";
                playMusicWithColorThread(musicString);
            } else if (button.getText().equals("Play 3")) {
                String musicString = "C5 D5 E5 F5 G5 A5 B5 C6 D6 E6 F6 G6 A6 B6 C7 D7 E7 F7 G7 A7 B7";
                playMusicWithColorThread(musicString);
            } else {
                String note = button.getText();
                player.play(note);

                button.setBackground(Color.YELLOW);

                Timer timer = new Timer(200, new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        button.setBackground(null);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    private void playMusicWithColorThread(String musicString) {
        Thread musicThread = new Thread(() -> {
            player.play(musicString);
        });
        musicThread.start();
    
        // Altera a cor de fundo das notas correspondentes para amarelo no momento exato
        Thread colorThread = new Thread(() -> {
            int repetition = 0;
            while (repetition < 3) {  // Repetir 3 vezes
                for (int i = 0; i < musicString.length(); i++) {
                    if (Thread.interrupted()) {
                        return;  // Interrompe o thread se foi interrompido
                    }
                    
                    char noteChar = musicString.charAt(i);
                    if (noteChar != ' ') {
                        String note = String.valueOf(noteChar);
                        int index = findNoteIndex(note);
                        if (index != -1) {
                            pianoKeys[index].setBackground(Color.YELLOW);
                            try {
                                // Ajuste o valor abaixo para alterar o atraso entre as notas
                                Thread.sleep(300);  // Atraso de 300ms entre as notas
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                                return;  // Interrompe o thread se ocorrer uma exceção
                            }
                            pianoKeys[index].setBackground(null);
                        }
                    }
                }
                repetition++;
            }
        });
    
        colorThread.start();
    
        // Aguarda a conclusão da reprodução da música e interrompe o thread de alteração de cores
        Thread completionThread = new Thread(() -> {
            try {
                musicThread.join();
                colorThread.interrupt();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        completionThread.start();
    }
    
    

    private int findNoteIndex(String note) {
        for (int i = 0; i < notes.length; i++) {
            if (notes[i].equals(note)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PianoInterface().setVisible(true);
            }
        });
    }
}
