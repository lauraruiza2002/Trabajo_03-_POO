import java.awt.*;  // Importar biblioteca Swing
import javax.swing.*;  // Importar biblioteca AWT para diseño

// Clase principal
public class Ejercicio_22_IG {
    public static void main(String[] args) {
        // Crear una instancia de la ventana
        MyWindow_22 window_22 = new MyWindow_22();
        window_22.setVisible(true);  // Hacer la ventana visible
    }
}

// Clase para crear la ventana
class MyWindow_22 extends JFrame {
    private JTextField inputField;
    private JButton submitButton;
    private JLabel instructionLabel;
    private int step = 0;  //Uso del step para que los campos a rellenar aparaezcan uno por uno
    private String nombre;
    private double horas_trabajo;
    private double valor_hora_trabajo;
  

    public MyWindow_22() {
        // Configuración de la ventana
        setTitle("Salario Empleado");  // Título de la ventana
        setSize(400, 200);  // Tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear componentes iniciales
        instructionLabel = new JLabel("Ingrese el nombre del empleado:");
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
                    nombre = inputField.getText();
                    instructionLabel.setText("Ingrese las horas trabajadas:");
                    inputField.setText("");
                    break;
                case 1:
                    horas_trabajo = Double.parseDouble(inputField.getText());
                    instructionLabel.setText("Ingrese el valor de la hora de trabajo:");
                    inputField.setText("");
                    break;
                case 2:
                    valor_hora_trabajo = Double.parseDouble(inputField.getText());
                    calculate_salario();
                    break;
              
            }
            step++;
        } catch (NumberFormatException e) {
            instructionLabel.setText("Por favor ingrese un valor numérico válido.");
            inputField.setText("");
        }
    }

    // Clase para mostrar los resultados del salario del empleado
    
    private void calculate_salario() {


        double salario  = horas_trabajo * valor_hora_trabajo;
        
        if (salario > 450000) {

            instructionLabel.setText("<html> Nombre del empleado: " + nombre +
                                     "<br> Salario: $" + salario + "<html>");

        } else {
            
            instructionLabel.setText("<html> Nombre del empleado: " + nombre);
        }

        inputField.setVisible(false);
        submitButton.setEnabled(false);
    }

}