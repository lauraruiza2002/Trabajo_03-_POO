import java.awt.*;  // Importar biblioteca Swing
import javax.swing.*;  // Importar biblioteca AWT para diseño

// Clase principal
public class Ejercicio_7_IG {
    public static void main(String[] args) {

        // Crear una instancia de la ventana
        MyWindow_7 window_7 = new MyWindow_7();
        window_7.setVisible(true);  // Hacer la ventana visible
    }
}

// Clase para crear la ventana
class MyWindow_7 extends JFrame {

    private JTextField inputField;
    private JButton submitButton;
    private JLabel instructionLabel;
    private int step = 0;  //Uso del step para que los campos a rellenar aparaezcan uno por uno
 
    private int A;
    private int B;


    public MyWindow_7() {

        // Configuración de la ventana

        setTitle("¿Qué número es mayor o menor?");  // Título de la ventana
        setSize(400, 200);  // Tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear componentes iniciales
        instructionLabel = new JLabel("Ingrese el valor de A:");
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
                    A = Integer.parseInt(inputField.getText());
                    instructionLabel.setText("Ingrese el valor de B:");
                    inputField.setText("");
                    break;

                case 1:
                    B = Integer.parseInt(inputField.getText());
                    calculate_orden();
                    break;
            }
            step++;
        } catch (NumberFormatException e) {
            instructionLabel.setText("Por favor ingrese un valor numérico válido.");
            inputField.setText("");
        }
    }


    // Clase para mostrar los resultados de que numero es mayor,menor o igual
    
    private void calculate_orden() {

        if (A > B){

            instructionLabel.setText("<html> A es mayor que B");
        }
        else if (A < B){

            instructionLabel.setText("<html> A es menor que B");
        }
        else{

            instructionLabel.setText("<html> A es igual a B");
        }
                               
        inputField.setVisible(false);
        submitButton.setEnabled(false);
    }
}