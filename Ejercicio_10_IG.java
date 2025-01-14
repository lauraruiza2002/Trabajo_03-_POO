import java.awt.*;  // Importar biblioteca Swing
import javax.swing.*;  // Importar biblioteca AWT para diseño

// Clase principal
public class Ejercicio_10_IG {
    public static void main(String[] args) {
        // Crear una instancia de la ventana
        MyWindow_10 window_10 = new MyWindow_10();
        window_10.setVisible(true);  // Hacer la ventana visible
    }
}

// Clase para crear la ventana
class MyWindow_10 extends JFrame {
    private JTextField inputField;
    private JButton submitButton;
    private JLabel instructionLabel;
    private int step = 0;  //Uso del step para que los campos a rellenar aparaezcan uno por uno
    private int numero_inscripcion;
    private String nombre;
    private double patrimonio;
    private double estrato_social;
  

    public MyWindow_10() {
        // Configuración de la ventana
        setTitle("Pago Matricula Universidad");  // Título de la ventana
        setSize(400, 400);  // Tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear componentes iniciales
        instructionLabel = new JLabel("Ingrese el número de inscripción del estudiante:");
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
                    numero_inscripcion = Integer.parseInt(inputField.getText());
                    instructionLabel.setText("Ingrese el nombre del estudiante:");
                    inputField.setText("");
                    break;
                case 1:
                    nombre = inputField.getText();
                    instructionLabel.setText("Ingrese el valor del patrimonio:");
                    inputField.setText("");
                    break;
                case 2:
                    patrimonio = Double.parseDouble(inputField.getText());
                    instructionLabel.setText("Ingrese el estrato social:");
                    inputField.setText("");
                    break;
                case 3:
                    estrato_social = Double.parseDouble(inputField.getText());
                    calculate_matricula();
                    break;
              
            }
            step++;
        } catch (NumberFormatException e) {
            instructionLabel.setText("Por favor ingrese un valor numérico válido.");
            inputField.setText("");
        }
    }

    // Clase para mostrar los resultados del valor de la matricula
    
    private void calculate_matricula() {

        double incremento = 30; //porcentaje
        double valor_inicial = 50000;
        double total;

        if (estrato_social > 3 && patrimonio > 2e6){

            total = valor_inicial + (patrimonio * (incremento / 100));

       } else{

           total = valor_inicial;
       }

       instructionLabel.setText("<html> Número de inscripción: " + numero_inscripcion +
                                "<br> Nombres: " + nombre +
                                "<br> Pago Matricula: " + total + "<html>");

        inputField.setVisible(false);
        submitButton.setEnabled(false);
                        
        }

}