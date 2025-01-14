import java.awt.*;  // Importar biblioteca Swing
import javax.swing.*;  // Importar biblioteca AWT para diseño

// Clase principal
public class Ejercicio_19_IG {
    public static void main(String[] args) {

        // Crear una instancia de la ventana
        MyWindow_19 window_19 = new MyWindow_19();
        window_19.setVisible(true);  // Hacer la ventana visible
    }
}

// Clase para crear la ventana
class MyWindow_19 extends JFrame {

    private JTextField inputField;
    private JButton submitButton;
    private JLabel instructionLabel;
    //private int step = 0;  //Uso del step para que los campos a rellenar aparaezcan uno por uno
 
    private int Lado;


    public MyWindow_19() {

        // Configuración de la ventana

        setTitle("Triángulo Equilatero");  // Título de la ventana
        setSize(400, 200);  // Tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear componentes iniciales
        instructionLabel = new JLabel("Ingrese el valor del lado del triángulo:");
        inputField = new JTextField(20);
        submitButton = new JButton("Enviar");

        // Agregar componentes a la ventana
        add(instructionLabel);
        add(inputField);
        add(submitButton);

        // Agregar acción al botón
        submitButton.addActionListener(e -> calculate_geometry());
    }


    

    // Clase para mostarr los resultados de la geometria del triangulo
    
    private void calculate_geometry() {

       double lado = Double.parseDouble(inputField.getText());
    
        double altura = (Math.sqrt(3)/2)* lado;
        double perimetro = 3* lado;
        double area = (Math.sqrt(3) / 4) * (Math.pow(lado,2));

        instructionLabel.setText("<html>Lado: " + lado +
                                "<br>Altura: " +  String.format("%.2f", altura) +
                                "<br>Perimetro: " +  String.format("%.2f", perimetro) +
                                "<br>Área: " + String.format("%.2f", area) + "</html>");
                               
        inputField.setVisible(false);
        submitButton.setEnabled(false);
    }
}