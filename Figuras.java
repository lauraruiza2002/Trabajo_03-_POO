import java.awt.*;  // Importar biblioteca Swing
import javax.swing.*;  // Importar biblioteca AWT para diseño

// Clase principal para ejecutar la interfaz
public class Figuras {
    public static void main(String[] args) {
        // Crear una instancia de la ventana principal
        MyWindow_fig window_fig = new MyWindow_fig();
        window_fig.setVisible(true);  // Hacer la ventana visible
    }
}

// Clase para crear la ventana principal
class MyWindow_fig extends JFrame {
    private JComboBox<String> figureSelector;
    private JTextField inputField1;
    private JTextField inputField2;
    private JButton calculateButton;
    private JLabel resultLabel;

    public MyWindow_fig() {
        // Configuración de la ventana
        setTitle("Calculadora de Figuras Geométricas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear componentes
        figureSelector = new JComboBox<>(new String[]{"Círculo", "Cuadrado", "Rectángulo", "Triángulo Rectángulo", "Rombo", "Trapecio"});
        inputField1 = new JTextField(10);
        inputField2 = new JTextField(10);
        calculateButton = new JButton("Calcular");
        resultLabel = new JLabel("Resultados: ");

        // Agregar componentes a la ventana
        add(new JLabel("Seleccione la figura:"));
        add(figureSelector);
        add(new JLabel("Ingrese el primer valor:"));
        add(inputField1);
        add(new JLabel("Ingrese el segundo valor (si aplica):"));
        add(inputField2);
        add(calculateButton);
        add(resultLabel);

        // Agregar acción al botón
        calculateButton.addActionListener(e -> calculate());
    }

    private void calculate() {
        String figure = (String) figureSelector.getSelectedItem();
        try {
            double value1 = Double.parseDouble(inputField1.getText());
            double value2 = Double.parseDouble(inputField2.getText());
            String result = "";

            switch (figure) {
                case "Círculo":
                    Circulo circulo = new Circulo(value1);
                    result = "Área: " + circulo.calcularArea() + ", Perímetro: " + circulo.calcularPerimetro();
                    break;
                case "Cuadrado":
                    Cuadrado cuadrado = new Cuadrado((int) value1);
                    result = "Área: " + cuadrado.calcularArea() + ", Perímetro: " + cuadrado.calcularPerimetro();
                    break;
                case "Rectángulo":
                    Rectangulo rectangulo = new Rectangulo((int) value1, (int) value2);
                    result = "Área: " + rectangulo.calcularArea() + ", Perímetro: " + rectangulo.calcularPerimetro();
                    break;
                case "Triángulo Rectángulo":
                    TrianguloRectangulo triangulo = new TrianguloRectangulo((int) value1, (int) value2);
                    result = "Área: " + triangulo.calcularArea() + ", Perímetro: " + triangulo.calcularPerimetro() +
                            ", Hipotenusa: " + triangulo.calcularHipotenusa() + ", Tipo: " + triangulo.determinarTipoTriangulo();
                    break;
                case "Rombo":
                    Rombo rombo = new Rombo(value1, value2);
                    result = "Área: " + rombo.calcularArea() + ", Perímetro: " + rombo.calcularPerimetro();
                    break;
                case "Trapecio":
                    Trapecio trapecio = new Trapecio(value1, value2, 10); // Suponemos una altura de 10 por simplicidad
                    result = "Área: " + trapecio.calcularArea() + ", Perímetro: " + trapecio.calcularPerimetro();
                    break;
            }

            resultLabel.setText("Resultados: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Por favor ingrese valores numéricos válidos.");
        }
    }
}

// Clases de Figuras Geométricas
class Circulo {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

class Cuadrado {
    private int lado;

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        return lado * lado;
    }

    public double calcularPerimetro() {
        return 4 * lado;
    }
}

class Rectangulo {
    private int base;
    private int altura;

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }

    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}

class TrianguloRectangulo {
    private int base;
    private int altura;

    public TrianguloRectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return (base * altura) / 2.0;
    }

    public double calcularPerimetro() {
        return base + altura + calcularHipotenusa();
    }

    public double calcularHipotenusa() {
        return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
    }

    public String determinarTipoTriangulo() {
        if (base == altura) return "Equilátero";
        if (base != altura && (base == calcularHipotenusa() || altura == calcularHipotenusa())) return "Isósceles";
        return "Escaleno";
    }
}

class Rombo {
    private double diagonalMayor;
    private double diagonalMenor;

    public Rombo(double diagonalMayor, double diagonalMenor) {
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
    }

    public double calcularArea() {
        return (diagonalMayor * diagonalMenor) / 2;
    }

    public double calcularPerimetro() {
        double lado = Math.sqrt(Math.pow(diagonalMayor / 2, 2) + Math.pow(diagonalMenor / 2, 2));
        return 4 * lado;
    }
}

class Trapecio {
    private double baseMayor;
    private double baseMenor;
    private double altura;

    public Trapecio(double baseMayor, double baseMenor, double altura) {
        this.baseMayor = baseMayor;
        this.baseMenor = baseMenor;
        this.altura = altura;
    }

    public double calcularArea() {
        return ((baseMayor + baseMenor) / 2) * altura;
    }

    public double calcularPerimetro() {
        double lado1 = Math.sqrt(Math.pow((baseMayor - baseMenor) / 2, 2) + Math.pow(altura, 2));
        return baseMayor + baseMenor + 2 * lado1;
    }
}
