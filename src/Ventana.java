import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * @author Blanca
 *
 */
public class Ventana extends JFrame implements ActionListener{
	private JTextField txtN1= new JTextField();
	private JTextField txtN2= new JTextField();
	
	private JLabel lbN1= new JLabel("Número 1:");
	private JLabel lbN2= new JLabel("Número 2:");
	private JLabel lbResultado= new JLabel("El resultado es:");
	
	private JButton btnSuma= new JButton("+");
	private JButton btnResta= new JButton("-");
	private JButton btnMultiplicacion= new JButton("*");
	private JButton btnDivision= new JButton("/");
	
	private Container c = getContentPane();
	
	private Operaciones op = new Operaciones();

	public Ventana(){
		super.setTitle("Operaciones");
		super.setSize(340, 480);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControles();
	}
	/**
	 * Se cargan todos los elementos a la ventana y se les coloca tamaño y ubicación
	 */
	private void cargarControles() {
		c.setLayout(null);
		lbN1.setBounds(10,10, 280, 30);
		txtN1.setBounds(10, 40, 280, 30);

		lbN2.setBounds(10,80, 280, 30);
		txtN2.setBounds(10, 120, 280, 30);

		btnSuma.setBounds(10, 160, 50, 30);
		btnResta.setBounds(80, 160, 50, 30);
		btnMultiplicacion.setBounds(160, 160, 50, 30);
		btnDivision.setBounds(230, 160, 50, 30);
		lbResultado.setBounds(10,200, 280,30);
		
		c.add(lbN1);
		c.add(txtN1);
		c.add(lbN2);
		c.add(txtN2);
		c.add(btnSuma);
		c.add(btnResta);
		c.add(btnMultiplicacion);
		c.add(btnDivision);
		c.add(lbResultado);
		
		btnSuma.addActionListener(this);
		btnResta.addActionListener(this);
		btnMultiplicacion.addActionListener(this);
		btnDivision.addActionListener(this);
	}

	/**
	 * 
	 * @param metodo con el cual al seleccionar el botón se puede llevar a cabo una accion
	 * en este caso un incluyendo un if para identificar el tipo de accion
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object btn = e.getSource();
		if(btn==btnSuma){
			int r = op.sumar(Integer.parseInt(txtN1.getText()), Integer.parseInt(txtN2.getText()));
			lbResultado.setText(String.format("%s + %s = %d", txtN1.getText(), txtN2.getText(), r));
		}else
		if(btn==btnResta){
			int r2 = op.resta(Integer.parseInt(txtN1.getText()), Integer.parseInt(txtN2.getText()));
			lbResultado.setText(String.format("%s - %s = %d", txtN1.getText(), txtN2.getText(), r2));
		}else
		if(btn==btnMultiplicacion){
			int r3 = op.multiplicacion(Integer.parseInt(txtN1.getText()), Integer.parseInt(txtN2.getText()));
			lbResultado.setText(String.format("%s * %s = %d", txtN1.getText(), txtN2.getText(), r3));
		}else
		if(btn==btnDivision){
			float r4 = op.division(Float.parseFloat(txtN1.getText()), Float.parseFloat(txtN2.getText()));
			lbResultado.setText(String.format("%s / %s = %f", txtN1.getText(), txtN2.getText(), r4));
		}	
	}
	
	
}
