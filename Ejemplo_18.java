import java.awt.*;  // Importar biblioteca Swing
import javax.swing.*;  // Importar biblioteca AWT para diseño

// Clase principal
public class Ejemplo_18 {
    public static void main(String[] args) {
        // Crear una instancia de la ventana
        MyWindow_2 window_2 = new MyWindow_2();
        window_2.setVisible(true);  // Hacer la ventana visible
    }
}

// Clase para crear la ventana
class MyWindow_2 extends JFrame {
    private JTextField inputField;
    private JButton submitButton;
    private JLabel instructionLabel;
    private int step = 0;  //Uso del step para que los campos a rellenar aparaezcan uno por uno
    private String codigo;
    private String nombre;
    private int horasTrabajadas;
    private double valorHora;
    private double retencionFuente;

    public MyWindow_2() {
        // Configuración de la ventana
        setTitle("Datos empleado");  // Título de la ventana
        setSize(400, 200);  // Tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear componentes iniciales
        instructionLabel = new JLabel("Ingrese el código del empleado:");
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
            switch (step) {  //Uso del SWC para que se completen todos los campos ya que dependen uno del otro
                case 0:
                    codigo = inputField.getText();
                    instructionLabel.setText("Ingrese el nombre del empleado:");
                    inputField.setText("");
                    break;
                case 1:
                    nombre = inputField.getText();
                    instructionLabel.setText("Ingrese el número de horas trabajadas al mes:");
                    inputField.setText("");
                    break;
                case 2:
                    horasTrabajadas = Integer.parseInt(inputField.getText());
                    instructionLabel.setText("Ingrese el valor de hora trabajada:");
                    inputField.setText("");
                    break;
                case 3:
                    valorHora = Double.parseDouble(inputField.getText());
                    instructionLabel.setText("Ingrese el porcentaje de retención en la fuente:");
                    inputField.setText("");
                    break;
                case 4:
                    retencionFuente = Double.parseDouble(inputField.getText());
                    calculateSalary();
                    break;
            }
            step++;
        } catch (NumberFormatException e) {
            instructionLabel.setText("Por favor ingrese un valor numérico válido.");
            inputField.setText("");
        }
    }

    // Clase para mostarr los resultados de los datos del empleado
    
    private void calculateSalary() {
        double salarioBruto = horasTrabajadas * valorHora;
        double retencion = salarioBruto * (retencionFuente / 100);
        double salarioNeto = salarioBruto - retencion;

        instructionLabel.setText("<html>Empleado: " + nombre +
                                "<br>Código: " + codigo +
                                "<br>Salario bruto: $" + String.format("%.2f", salarioBruto) +
                                "<br>Retención: $" + String.format("%.2f", retencion) +
                                "<br>Salario neto: $" + String.format("%.2f", salarioNeto) + "</html>");
        inputField.setVisible(false);
        submitButton.setEnabled(false);
    }
}