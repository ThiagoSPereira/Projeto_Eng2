package unico;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Tela implements ActionListener {

	Registro[] reg = new Registro[12];
	String listData[] = { "Vaga 1", "Vaga 2", "Vaga 3", "Vaga 4", "Vaga 5", "Vaga 6", "Vaga 7", "Vaga 8", "Vaga 9",
			"Vaga 10", "Vaga 11", "Vaga 12" };
	String vagasDiponiveis;
	JList vagas;

	JTable historico;
	DefaultTableModel modelo = new DefaultTableModel();

	ArrayList<String> shistorico;
	String valorFinal;
	JButton registrar;
	JButton pagar;
	JButton pago;
	JButton preco;
	JButton consulta;
	JTextField jNome;
	JTextField jRg;
	JTextField jPlaca;
	JTextField jMarca;
	JTextField jModelo;
	JTextField jEntrada;
	JTextField jSaida;
	JTextField jReais;
	JTextField jCentavos;
	JTextField aPagar;
	int aux;
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	Calcula calc = new Calcula();
	JScrollPane barraRolagem;

	public void Incio() {

		JTabbedPane tab = new JTabbedPane();
		
		
		
		JPanel janRegistro = new JPanel();
		JPanel janHistorico = new JPanel();
		janRegistro.setLayout(null);
		janHistorico.setLayout(null);

		tab.add("Registra", janRegistro);
		tab.add("Historico", janHistorico);

		// for(int i = 0; i<12;i++){
		// reg[i] = new Registro();
		// }

		// Create a new listbox control
		vagas = new JList(listData);
		vagas.setBounds(10, 20, 100, 220);
		vagas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				aux = vagas.getSelectedIndex();
				if (reg[vagas.getSelectedIndex()] != null) {
					System.out.println(reg[vagas.getSelectedIndex()].nome);
					jNome.setText(reg[vagas.getSelectedIndex()].nome.toString());
					jRg.setText(reg[vagas.getSelectedIndex()].rg.toString());
					jPlaca.setText(reg[vagas.getSelectedIndex()].placa.toString());
					jModelo.setText(reg[vagas.getSelectedIndex()].modelo.toString());
					jMarca.setText(reg[vagas.getSelectedIndex()].marca.toString());
					jEntrada.setText(sdf.format(reg[vagas.getSelectedIndex()].entrada));
				} else {
					jNome.setText(null);
					jRg.setText(null);
					jPlaca.setText(null);
					jModelo.setText(null);
					jMarca.setText(null);
					jEntrada.setText(null);
					jSaida.setText(null);
					aPagar.setText(null);
				}

			}
		});

		registrar = new JButton("Registrar");
		registrar.setBounds(500, 250, 100, 25);
		registrar.addActionListener(this);

		pagar = new JButton("Pagar");
		pagar.setBounds(620, 250, 100, 25);
		pagar.addActionListener(this);
		
		pago = new JButton("Pago");
		pago.setBounds(620, 290, 100, 25);
		pago.addActionListener(this);
		
		consulta = new JButton("Vagas Disponiveis");
		consulta.setBounds(300, 250, 180, 25);
		consulta.addActionListener(this);
		
		preco = new JButton("Alterar");
		preco.setBounds(660, 50, 100, 25);
		preco.addActionListener(this);


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

		JLabel labelEntrada = new JLabel("Entrada:");
		labelEntrada.setBounds(440, 80, 80, 20);
		jEntrada = new JTextField();
		jEntrada.setEditable(false);
		jEntrada.setBounds(510, 80, 200, 20);

		JLabel labelSaida = new JLabel("Saida:");
		labelSaida.setBounds(440, 110, 50, 20);
		jSaida = new JTextField();
		jSaida.setEditable(false);
		jSaida.setBounds(510, 110, 200, 20);
		
		JLabel valor = new JLabel("Valor a pagar:");
		valor.setBounds(440, 150, 150, 20);
		aPagar = new JTextField();
		aPagar.setEditable(false);
		aPagar.setBounds(570, 150, 100, 20);
		
		JLabel labelReais = new JLabel("Novo preco:");
		labelReais.setBounds(620, 10, 120, 20);
		jReais = new JTextField();
		jReais.setBounds(700, 10, 30, 20);
		
		JLabel labelCent = new JLabel(",");
		labelCent.setBounds(733, 15, 100, 20);
		jCentavos = new JTextField();
		jCentavos.setBounds(737, 10, 20, 20);
		
		//Tabela historico
		historico = new JTable(modelo);
		historico.setBounds(20, 10, 550, 300);
		Registro registro =new Registro();
	
		modelo.addColumn("Nome");
		modelo.addColumn("RG");
		modelo.addColumn("Marca");
		modelo.addColumn("Modelo");
		modelo.addColumn("Placa");
		modelo.addColumn("Entrada");
		modelo.addColumn("Saida");
		modelo.addColumn("Pagar");
		barraRolagem = new JScrollPane(historico);
		barraRolagem = new JScrollPane(historico);
		historico.getColumnModel().getColumn(0).setPreferredWidth(10);
		historico.getColumnModel().getColumn(1).setPreferredWidth(10);;
		historico.getColumnModel().getColumn(2).setPreferredWidth(10);;
		historico.getColumnModel().getColumn(3).setPreferredWidth(10);
		historico.getColumnModel().getColumn(4).setPreferredWidth(10);
		
		
		// adiciona componentes
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
		janRegistro.add(consulta);
		janRegistro.add(valor);
		janRegistro.add(aPagar);
		janRegistro.add(pago);
		
		janHistorico.add(labelReais);
		janHistorico.add(jReais);
		janHistorico.add(labelCent);
		janHistorico.add(jCentavos);
		janHistorico.add(preco);
		janHistorico.add(historico);

		JFrame frame = new JFrame("Estacionamento");
		frame.setSize(800, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		frame.add(tab);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(registrar)) {
			reg[vagas.getSelectedIndex()] = new Registro();
			reg[vagas.getSelectedIndex()].nome = jNome.getText();
			reg[vagas.getSelectedIndex()].rg = jRg.getText();
			reg[vagas.getSelectedIndex()].modelo = jModelo.getText();
			reg[vagas.getSelectedIndex()].marca = jMarca.getText();
			reg[vagas.getSelectedIndex()].placa = jPlaca.getText();
			reg[vagas.getSelectedIndex()].entrada = new Date();
			jEntrada.setText(sdf.format(reg[vagas.getSelectedIndex()].entrada));
		}
		if (e.getSource().equals(pagar)) {
			reg[vagas.getSelectedIndex()].saida = new Date();
			jSaida.setText(sdf.format(reg[vagas.getSelectedIndex()].saida));
			aPagar.setText(calc.ValorPagar(reg[vagas.getSelectedIndex()].entrada, reg[vagas.getSelectedIndex()].saida));

			modelo.addRow(new Object[] { jNome.getText(), jRg.getText(), jMarca.getText(), jModelo.getText(),
					jPlaca.getText(), jEntrada.getText(), jSaida.getText(), aPagar.getText() });

		}
		if (e.getSource().equals(preco)) {
			calc.Preco(jReais.getText(), jCentavos.getText());

			System.out.println(calc.preco);
		}
		
		if (e.getSource().equals(pago)) {
			reg[vagas.getSelectedIndex()] = null;
			jNome.setText(null);
			jRg.setText(null);
			jPlaca.setText(null);
			jModelo.setText(null);
			jMarca.setText(null);
			jEntrada.setText(null);
			jSaida.setText(null);
			aPagar.setText(null);			
		}

		if (e.getSource().equals(consulta)) {
			vagasDiponiveis = "Vagas disponiveis:";
			int i = 0;
			for (Registro vaga : reg) {
				i++;
				if (vaga == null) {

					vagasDiponiveis += i + "/";
				}
			}
			JOptionPane.showMessageDialog(null, vagasDiponiveis);

		}

	}

}
