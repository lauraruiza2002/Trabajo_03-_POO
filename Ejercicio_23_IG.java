import java.awt.*;  // Importar biblioteca Swing
import javax.swing.*;  // Importar biblioteca AWT para diseño

// Clase principal
public class Ejercicio_23_IG {
    public static void main(String[] args) {
        // Crear una instancia de la ventana
        MyWindow_23 window_23 = new MyWindow_23();
        window_23.setVisible(true);  // Hacer la ventana visible
    }
}

// Clase para crear la ventana
class MyWindow_23 extends JFrame {
    private JTextField inputField;
    private JButton submitButton;
    private JLabel instructionLabel;
    private int step = 0;  // Uso del step para que los campos a rellenar aparezcan uno por uno
    private double A;
    private double B;
    private double C;

    public MyWindow_23() {
        // Configuración de la ventana
        setTitle("Soluciones de la ecuación de 2DO orden");  // Título de la ventana
        setSize(400, 200);  // Tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear componentes iniciales
        instructionLabel = new JLabel("Ingrese el parametro A:");
        inputField = new JTextField(20);
        submitButton = new JButton("Enviar");

        // Agregar componentes a la ventana
        add(instructionLabel);
        add(inputField);
        add(submitButton);

        // Agregar acción al botón
        submitButton.addActionListener(e -> handleStep());
    }

    private void handleStep() {
        try {
            switch (step) {
                case 0:
                    A = Double.parseDouble(inputField.getText());
                    instructionLabel.setText("Ingrese el parametro B:");
                    inputField.setText("");
                    break;
                case 1:
                    B = Double.parseDouble(inputField.getText());
                    instructionLabel.setText("Ingrese el parametro C:");
                    inputField.setText("");
                    break;
                case 2:
                    C = Double.parseDouble(inputField.getText());
                    calculate_equation();
                    break;
            }
            step++;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido (puede ser negativo).", "Error de entrada", JOptionPane.WARNING_MESSAGE);
            inputField.setText("");
        }
    }

    // Método para mostrar los resultados de la solución de las ecuaciones según los parámetros
    private void calculate_equation() {
        double determinante = Math.pow(B, 2) - (4 * A * C);

        if (determinante > 0) {
            double x1 = (-B + Math.sqrt(determinante)) / (2 * A);
            double x2 = (-B - Math.sqrt(determinante)) / (2 * A);
            instructionLabel.setText("<html>Hay dos soluciones reales y distintas:<br>Solución X1 = " + x1 + "<br>Solución X2 = " + x2 + "</html>");
        } else if (determinante == 0) {
            double x0 = -B / (2 * A);
            instructionLabel.setText("<html>Hay una solución real con multiplicidad 2:<br>Solución X = " + x0 + "</html>");
        } else {
            double parteReal = -B / (2 * A);
            double parteImaginaria = Math.sqrt(-determinante) / (2 * A);
            instructionLabel.setText("<html>Hay dos soluciones complejas:<br>X1 = " + parteReal + " + " + parteImaginaria + "i" +
                                     "<br>X2 = " + parteReal + " - " + parteImaginaria + "i</html>");
        }

        inputField.setVisible(false);
        submitButton.setEnabled(false);
    }
}
