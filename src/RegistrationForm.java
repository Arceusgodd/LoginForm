import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.sql.Connection;



public class RegistrationForm implements ActionListener {
    JFrame frame;
    JLabel nameLabel = new JLabel("NAME");
    JLabel surnameLabel = new JLabel("SURNAME");
    JLabel fatherNameLabel = new JLabel("FATHER NAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel confirmPasswordLabel = new JLabel("CONFIRM PASSWORD");
    JLabel cityLabel = new JLabel("CITY");
    JLabel emailLabel = new JLabel("EMAIL");
    JTextField nameTextField = new JTextField();
    JTextField surnameTextField = new JTextField();
    JTextField fatherTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JTextField cityTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JButton registerButton = new JButton("REGISTER");
    JButton resetButton = new JButton("RESET");
    JLabel dobLabel = new JLabel("DOB");
    JTextField dobTextField = new JTextField("dd-mm-yy");
    JLabel addressLabel = new JLabel("ADDRESS");
    JTextField addressTextField = new JTextField();
    JLabel phoneLabel = new JLabel("FATHERS PHONE.NO.");
    JTextField phoneTextField = new JTextField();
    JLabel searchLabel = new JLabel("SEARCH");
    JTextField searchTextField = new JTextField("EMAIL ID HERE");
    JButton searchButton = new JButton("SEARCH");

    RegistrationForm() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();

    }

    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40, 40, 1100, 600);
        frame.getContentPane().setBackground(Color.yellow);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize() {
        nameLabel.setBounds(20, 20, 40, 70);
        surnameLabel.setBounds(20, 70, 100, 70);
        fatherNameLabel.setBounds(20, 120, 100, 70);
        passwordLabel.setBounds(20, 170, 100, 70);
        confirmPasswordLabel.setBounds(20, 220, 140, 70);
        cityLabel.setBounds(20, 270, 100, 70);
        emailLabel.setBounds(20, 320, 100, 70);
        nameTextField.setBounds(180, 43, 165, 23);
        surnameTextField.setBounds(180, 93, 165, 23);
        fatherTextField.setBounds(180, 143, 165, 23);
        passwordField.setBounds(180, 193, 165, 23);
        confirmPasswordField.setBounds(180, 243, 165, 23);
        cityTextField.setBounds(180, 293, 165, 23);
        emailTextField.setBounds(180, 343, 165, 23);
        registerButton.setBounds(400, 400, 100, 35);
        resetButton.setBounds(550, 400, 100, 35);
        dobLabel.setBounds(550, 20, 40, 70);
        dobTextField.setBounds(610, 45, 165, 23);
        addressLabel.setBounds(550, 70, 70, 70);
        addressTextField.setBounds(610, 90, 165, 25);
        phoneLabel.setBounds(550, 260, 140, 23);
        phoneTextField.setBounds(690, 260, 165, 23);
        searchLabel.setBounds(900, 20, 70, 70);
        searchTextField.setBounds(900, 70, 150, 23);
        searchButton.setBounds(900, 110, 100, 35);
    }

    public void addComponentsToFrame() {
        frame.add(nameLabel);
        frame.add(surnameLabel);
        frame.add(fatherNameLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(cityLabel);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(surnameTextField);
        frame.add(fatherTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(cityTextField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
        frame.add(dobLabel);
        frame.add(dobTextField);
        frame.add(addressLabel);
        frame.add(addressTextField);
        frame.add(phoneLabel);
        frame.add(phoneTextField);
        frame.add(searchLabel);
        frame.add(searchTextField);
        frame.add(searchButton);
    }

    public void actionEvent() {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        searchButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            try {
                Connection connection;
                Statement statement;
                String DB_URL = "jdbc:mysql://localhost:3306/sucess";
                connection = DriverManager.getConnection(DB_URL, "root", "");
                PreparedStatement Pstatement = connection.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?)");
                Pstatement.setString(1, nameTextField.getText());
                Pstatement.setString(2, surnameTextField.getText());
                Pstatement.setString(3, fatherTextField.getText());
                Pstatement.setString(4, passwordField.getText());
                Pstatement.setString(5, confirmPasswordField.getText());
                Pstatement.setString(6, cityTextField.getText());
                Pstatement.setString(7, emailTextField.getText());
                Pstatement.setString(8, dobTextField.getText());
                Pstatement.setString(9, addressTextField.getText());
                Pstatement.setString(10, phoneTextField.getText());
                if (passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText())) {

                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Registered Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Password did not match");
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        }
        if (e.getSource() == resetButton) {
            nameTextField.setText("");
            surnameTextField.setText("");
            fatherTextField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            cityTextField.setText("");
            emailTextField.setText("");
            addressTextField.setText("");
            dobTextField.setText("");
            phoneTextField.setText("");
        }
        if(e.getSource()== searchButton)
        {try {
            Connection connection;
            Statement statement;
            String DB_URL = "jdbc:mysql://localhost:3306/sucess";
            connection=DriverManager.getConnection(DB_URL,"root","");
            PreparedStatement Pstatement3=connection.prepareStatement("select * from student where email = ?");
            Pstatement3.setString(1,searchTextField.getText());
            //String str= dobTextField.getText();
            //Pstatement3.setString(8,str);
            ResultSet rs= Pstatement3.executeQuery();
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"Record found!");
                String s1=rs.getString(1);
                String s2=rs.getString(2);
                String s3=rs.getString(3);
                String s4=rs.getString(4);
                String s5=rs.getString(5);
                String s6=rs.getString(6);
                String s7=rs.getString(7);
                String s8=rs.getString(8);
                String s9 =rs.getString(9);
                String s10= rs.getString(10);
                nameTextField.setText(s1);
                surnameTextField.setText(s2);
                fatherTextField.setText(s3);
                passwordField.setText(s4);
                confirmPasswordField.setText(s5);
                cityTextField.setText(s6);
                emailTextField.setText(s7);
                dobTextField.setText(s8);
                addressTextField.setText(s9);
                phoneTextField.setText(s10);
            }
            else
            { JOptionPane.showMessageDialog(null,"Invalid Email Id .Record not found!");
            }
        }
        catch(SQLException e2)
        {   e2.printStackTrace();}
        }
    }
    }
