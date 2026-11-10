package gui;

import modelo.Usuario;
import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UsuarioGUI extends JFrame {

    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5;
    private JPanel jPanel1;
    private JTextField jTextField1, jTextField2, jTextField3, jTextField4;
    private JButton jButton1, jButton2, jButton3;

    public UsuarioGUI() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cadastro de Usuário");
        setLayout(null);

        jLabel1 = new JLabel("Cadastro de Usuário");
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jLabel1.setBounds(20, 10, 300, 30);
        add(jLabel1);

        jPanel1 = new JPanel(null);
        jPanel1.setBorder(BorderFactory.createTitledBorder("Cadastrar novo usuário"));
        jPanel1.setBounds(20, 50, 340, 220);
        add(jPanel1);

        jLabel2 = new JLabel("Nome");
        jLabel3 = new JLabel("CPF");
        jLabel4 = new JLabel("Email");
        jLabel5 = new JLabel("Telefone");
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();

        JLabel[] rotulos = {jLabel2, jLabel3, jLabel4, jLabel5};
        JTextField[] campos = {jTextField1, jTextField2, jTextField3, jTextField4};
        for (int i = 0; i < 4; i++) {
            rotulos[i].setBounds(20, 35 + i * 35, 70, 25);
            campos[i].setBounds(100, 35 + i * 35, 200, 25);
            jPanel1.add(rotulos[i]);
            jPanel1.add(campos[i]);
        }

        jButton1 = new JButton("Cadastrar");
        jButton1.setBounds(50, 180, 110, 28);
        jButton1.addActionListener(evt -> jButton1ActionPerformed());
        jPanel1.add(jButton1);

        jButton2 = new JButton("Limpar");
        jButton2.setBounds(180, 180, 110, 28);
        jButton2.addActionListener(evt -> jButton2ActionPerformed());
        jPanel1.add(jButton2);

        jButton3 = new JButton("SAIR");
        jButton3.setBounds(125, 290, 110, 28);
        jButton3.addActionListener(evt -> jButton3ActionPerformed());
        add(jButton3);

        setSize(395, 380);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    // Passo 9: evento CADASTRAR
    private void jButton1ActionPerformed() {
        // instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
        Usuario usuarios = new Usuario();
        usuarios.setNome(jTextField1.getText());
        usuarios.setCpf(jTextField2.getText());
        usuarios.setEmail(jTextField3.getText());
        usuarios.setTelefone(jTextField4.getText());

        // fazendo a validação dos dados
        if ((jTextField1.getText().isEmpty()) || (jTextField2.getText().isEmpty())
                || (jTextField3.getText().isEmpty()) || (jTextField4.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
        } else {
            try {
                // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
                UsuarioDAO dao = new UsuarioDAO();
                dao.adiciona(usuarios);
                JOptionPane.showMessageDialog(null, "Usuário " + jTextField1.getText() + " inserido com sucesso! ");
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
            }
        }
    }

    // Passo 8: evento LIMPAR
    private void jButton2ActionPerformed() {
        // apaga os dados preenchidos nos campos de texto
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }

    // Passo 7: evento SAIR
    private void jButton3ActionPerformed() {
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UsuarioGUI().setVisible(true));
    }
}
