package unico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;

public class Tela implements ActionListener {
 
	Registro[] reg = new Registro[12];
	String listData[] = { "Vaga 1", "Vaga 2", "Vaga 3", "Vaga 4", "Vaga 5", "Vaga 6", "Vaga 7", "Vaga 8", "Vaga 9",
			"Vaga 10", "Vaga 11", "Vaga 12" };
	JList vagas;
	JButton registrar;
	JButton pagar;
	JTextField jNome;
	JTextField jRg;
	JTextField jPlaca;
	JTextField jMarca;
	JTextField jModelo;
	JTextField jEntrada;
	JTextField jSaida;
	int aux;
	
	public void Incio(){
		
		JTabbedPane tab = new JTabbedPane();
		
		JPanel janRegistro = new JPanel();
		JPanel janHistorico = new JPanel();
		janRegistro.setLayout(null);
		
		tab.add("Registra", janRegistro);
		tab.add("Historico", janHistorico);
		
//		for(int i = 0; i<12;i++){
//			reg[i] = new Registro();
//		}
		
		// Create a new listbox control
		vagas = new JList( listData );
		vagas.setBounds(10, 20, 100, 220);
		vagas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
					aux = vagas.getSelectedIndex();	
					if(reg[aux] != null){
						System.out.println(reg[aux].nome);
					}
						
			}
		});
				
		registrar = new JButton("Registrar");
		registrar.setBounds(500, 500, 100, 25);
		registrar.addActionListener(this);
		
		pagar = new JButton("Pagar");
		pagar.setBounds(620, 500, 100, 25);
		pagar.addActionListener(this);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(160, 70, 50, 20);
		jNome = new JTextField();
		jNome.setBounds(230, 70, 200, 20);
		
		JLabel labelRg = new JLabel("Rg:");
		labelRg.setBounds(160, 100, 50, 20);
		jRg = new JTextField();
		jRg.setBounds(230, 100, 200, 20);
		
		JLabel labelPlaca = new JLabel("Placa:");
		labelPlaca.setBounds(160, 130, 50, 20);
		jPlaca = new JTextField();
		jPlaca.setBounds(230, 130, 200, 20);
		
		JLabel labelMarca = new JLabel("Marca:");
		labelMarca.setBounds(160, 160, 50, 20);
		jMarca = new JTextField();
		jMarca.setBounds(230, 160, 200, 20);
		
		JLabel labelModelo = new JLabel("Modelo:");
		labelModelo.setBounds(160, 190, 70, 20);
		jModelo = new JTextField();
		jModelo.setBounds(230, 190, 200, 20);
		
		JLabel labelEntrada= new JLabel("Entrada:");
		labelEntrada.setBounds(440, 80, 80, 20);
		jEntrada = new JTextField();
		jEntrada.setEditable(false);
		jEntrada.setBounds(510, 80, 200, 20);
		
		JLabel labelSaida= new JLabel("Saida:");
		labelSaida.setBounds(440, 110, 50, 20);
		jSaida = new JTextField();
		jSaida.setEditable(false);
		jSaida.setBounds(510, 110, 200, 20);

		
		//adiciona componentes
		janRegistro.add(vagas);
		janRegistro.add(jNome);
		janRegistro.add(jPlaca);
		janRegistro.add(jRg);
		janRegistro.add(jMarca);
		janRegistro.add(jModelo);
		janRegistro.add(registrar);
		janRegistro.add(pagar);
		janRegistro.add(jEntrada);
		janRegistro.add(jSaida);
		janRegistro.add(labelNome);
		janRegistro.add(labelRg);
		janRegistro.add(labelPlaca);
		janRegistro.add(labelMarca);
		janRegistro.add(labelModelo);
		janRegistro.add(labelEntrada);
		janRegistro.add(labelSaida);
				
		
		JFrame frame = new JFrame("Estacionamento");
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add(tab);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(registrar)){
			reg[aux] = new Registro();
			reg[aux].nome = jNome.getText() ;
			reg[aux].rg = jRg.getText();
			reg[aux].modelo = jModelo.getText();
			reg[aux].marca = jMarca.getText();
			reg[aux].placa = jPlaca.getText();
			reg[aux].entrada = Calendar.getInstance();
			jEntrada.setText(reg[aux].entrada.getTime().toString());
		}
		if(e.getSource().equals(pagar)){
			reg[aux].saida = Calendar.getInstance();
		}
		
	}
}
