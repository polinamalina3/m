package plata;
//��������� ���������� ��� ������ � ���������� ������, �������,
//��� �������� ������������ ����
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

//������� �����, ����������� ��������� ActionListener
//��������� ����� ��� ��������� ������� ������� �� ������
public class plata implements ActionListener{
    JFrame frame = new JFrame("���������"); //������� ����
    JPanel panelLeft = new JPanel(); //������ � �������
    JPanel panelRight = new JPanel(); //������ � ���������� ������
    JPanel panelBottom = new JPanel(); //������ � ��������
    public JTextField[] arrTf = new JTextField[18];//������ ��������� �����

    //�����������
    public plata(){
        //������������� �������� ���������� ��� ������ � �������
        //������ ������������ �� ���������
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        //������������  ������ 250 �� 300 ��������
        panelLeft.setPreferredSize(new Dimension(250, 300));

        //������������� �������� ���������� ��� ������ � ���������� ������
        //������ ������������ �� ���������
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        //�������������  ������ 130 �� 300 ��������
        panelRight.setPreferredSize(new Dimension(130,300));

        //�������� ����� ����� ����� addLabel
        addLabel(panelLeft, "����� �� �������� ����:", Color.RED);
        addLabel(panelLeft, "����� �� ������� ����:", Color.RED);
        addLabel(panelLeft, "����� �� ����:", Color.RED);
        addLabel(panelLeft, "����� �� ���:", Color.RED);
        addLabel(panelLeft, "���������� �����������:", Color.RED);
        addLabel(panelLeft, "����� ������������ ����:", Color.RED);
        addLabel(panelLeft, "����� ����������� ������� ����:", Color.RED);
        addLabel(panelLeft, "����� ����������� �������� ����:", Color.RED);
        addLabel(panelLeft, "����� ������������ �����:", Color.RED);
        addLabel(panelLeft, "������������ ������:", Color.RED);
        addLabel(panelLeft, "���� �� ������� �����:", Color.RED);
        addLabel(panelLeft, "��������� � �������� ������:", Color.RED);
        addLabel(panelLeft, "������� �������� ����:", Color.BLUE);
        addLabel(panelLeft, "������� ������� ����:", Color.BLUE);
        addLabel(panelLeft, "������� ����:", Color.BLUE);
        addLabel(panelLeft, "������� �����:", Color.BLUE);
        addLabel(panelLeft, "������� ������������ �����:", Color.BLUE);
        addLabel(panelLeft, "����� �����:", Color.BLUE);
        //��������� ��������� ���� ����� ���� � ���������� �� � ������
        for(int i=0; i<arrTf.length; i++){
            if(arrTf.length>=0){
                //���������� ������ �� ������ � ������ ��� ���������� ������ �
                //�������� �����
                arrTf[i] = addTextField(panelRight);}

        }


        //��������� ������ ������� � ������
        JButton calc = addButton(panelBottom, "������");
        //��������� ��������� �� ������� �������
        calc.addActionListener(this);
        JButton reset = addButton(panelBottom, "�����");
        //��������� ��������� �� ������� �������
        reset.addActionListener(this);


        //������ ������� ����� �������
        frame.setVisible(true);
        //������������� �������� ��� ������� �� ������� - ���������� ����������
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //������������� ��������� ��������� ������������ ������ ������ (�� ������)
        frame.setLocationRelativeTo(null);
        //������������� ������ �������� ����(400 �� 450)
        frame.setSize(400,450);
        //��������� ����� � ����������� � ������ � ����� ���� ����
        JLabel top = new JLabel("������� ���� �������� ������������� ��� ����������");
        //������������� ������������ ������ � ����� �� ������
        top.setHorizontalAlignment(JLabel.CENTER);

        //��������� ������ �� ������� ����
        frame.add(top, BorderLayout.NORTH);
        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(panelRight, BorderLayout.EAST);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.setResizable(false); //��������� ��������� �������� �������� ����

    }


    //����� ���������� ��������� �����
    public void addLabel(JComponent container, String name, Color color){
        //������� �������� ����� � ������ name
        JLabel lb = new JLabel(name);
        //������������� ����������� ���������� ������
        lb.setMaximumSize(new Dimension(400,20));
        //������������� ����� ������
        lb.setForeground(color);
        //������������� ������������ �� ������� ����
        lb.setHorizontalAlignment(JLabel.RIGHT);
        //��������� �����
        lb.setBorder(new EtchedBorder());
        //��������� ��������� ����� � ������
        container.add(lb);
    }

    //����� ���������� ��������� �����
    public JTextField addTextField(JComponent container){
        //������� ��������� ����
        JTextField tf = new JTextField();
        //������������� ��� ����������� ���������� ������
        tf.setMaximumSize(new Dimension(150,20));
        //��������� ��������� ���� �� ������
        container.add(tf);
        //���������� ������ �� ��������� ����
        return tf;
    }

    //����� ���������� ������
    public JButton addButton(JComponent container, String name){
        //������� ������
        JButton btn = new JButton(name);
        //������������� ����������� ���������� ������
        btn.setMaximumSize(new Dimension(100,20));
        //����������� �� ����������� �� ������
        btn.setHorizontalAlignment(JButton.CENTER);

        //��������� ������ �� ������
        container.add(btn);
        //���������� ������ �� ������
        return btn;
    }


    //����� �������
    public void kvartira() throws Exception{
        double c = 0;
        double h = 0;
        double s = 0;
        double g = 0;
        double k = 0;
        double vg = 0;
        double vh = 0;
        double vc = 0;
        double vs = 0;
        double u = 0;
        double d = 0;
        double p = 0;
        double q1 = 0;
        double q2 = 0;
        double q3 = 0;
        double q4 = 0;
        double q5 = 0;
        double summa = 0;


         for (int i=0; i < 18; i++) {
            if (arrTf[i].getText().length() == 0) {
                arrTf[i].setText(" ");
            }
        }


        if (!arrTf[0].getText().equals(" ")) {
            c = Double.valueOf(arrTf[0].getText()); //cold water
        }
        if (!arrTf[1].getText().equals(" ")) {
            h = Double.valueOf(arrTf[1].getText()); //hot water
        }
        if (!arrTf[2].getText().equals(" ")) {
            s = Double.valueOf(arrTf[2].getText()); //svet
        }
        if (!arrTf[3].getText().equals(" ")) {
            g = Double.valueOf(arrTf[3].getText()); //gas
        }
        if (!arrTf[4].getText().equals(" ")) {
            k = Double.valueOf(arrTf[4].getText()); //kolichestvo projivayuchih
        }
        if (!arrTf[5].getText().equals(" ")) {
            vg = Double.valueOf(arrTf[5].getText()); //v potrachennogo gasa
        }
        if (!arrTf[6].getText().equals(" ")) {
            vh = Double.valueOf(arrTf[6].getText()); //v potrachennogo hot water
        }
        if (!arrTf[7].getText().equals(" ")) {
            vc = Double.valueOf(arrTf[7].getText()); //v potrachennogo cold water
        }
        if (!arrTf[8].getText().equals(" ")) {
            vs = Double.valueOf(arrTf[8].getText()); //v potrachennogo svet
        }
        if (!arrTf[9].getText().equals(" ")) {
            u = Double.valueOf(arrTf[9].getText()); //kommunalnye uslugy
        }
        if (!arrTf[10].getText().equals(" ")) {
            d = Double.valueOf(arrTf[10].getText()); //dolg
        }
        if (!arrTf[11].getText().equals(" ")) {
            p = Double.valueOf(arrTf[11].getText());//pereplata
        }
        if (!arrTf[12].getText().equals(" ")) {
            q1 = Double.valueOf(arrTf[12].getText()); 
        }
        if (!arrTf[13].getText().equals(" ")) {
            q2 = Double.valueOf(arrTf[13].getText()); 
        }
        if (!arrTf[14].getText().equals(" ")) {
            q3 = Double.valueOf(arrTf[14].getText()); 
        }
        if (!arrTf[15].getText().equals(" ")) {
            q4 = Double.valueOf(arrTf[15].getText()); 
        }
        if (!arrTf[16].getText().equals(" ")) {
            q5 = Double.valueOf(arrTf[16].getText()); 
        }
        


        if ((c != 0) & (vc != 0)) {
            q1 = c*vc; //Cena na cold water
            arrTf[12].setText(String.format("%.2f", q1)); //������� ���� � 13 �.�.
        }
        else {
            arrTf[12].setText(" "); //������� ���� � 13 �.�.
        }
        if ((h != 0) & (vh != 0)) {
            q2 = h*vh; //Cena na hot water
            arrTf[13].setText(String.format("%.2f", q2)); //������� ���� � 14 �.�.
        }
        else {
            arrTf[13].setText(" "); //������� ���� � 14 �.�.
        }
        if ((g != 0) & (vg != 0)) {
            q3 = g*vg; //Cena na gas
            arrTf[14].setText(String.format("%.2f", q3)); //������� ���� � 15 �.�.
        }
        else {
            arrTf[14].setText(" "); //������� ���� � 15 �.�.
        }
        if ((s != 0) & (vs != 0)) {
            q4 = s*vs; //Cena na svet
            arrTf[15].setText(String.format("%.2f", q4)); //������� ���� � 16 �.�.
        }
        else {
            arrTf[15].setText(" "); //������� ���� � 16 �.�.
        }
        if ((k != 0) & (u != 0)) {
            q5 = k*u; //Cena na kommunalnye uslugy
            arrTf[16].setText(String.format("%.2f", q5)); //������� ���� � 17 �.�.
        }
        else {
            arrTf[16].setText(" "); //������� ���� � 17 �.�.
        }
        if ((q1 != 0) || (q2 != 0) || (q3 != 0) || (q4 != 0) || (q5 != 0) || (d >= 0) || (p >= 0)) {
            summa = q1+q2+q3+q4+q5+d-p; //summa
            arrTf[17].setText(String.format("%.2f", summa));  //������� ���� � 18 �.�.
        }
        else {
            arrTf[17].setText(" ");  //������� ���� � 18 �.�.
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new plata();
            }
        });
    }

    //����� ��������� ������� ������� �� ������
    @Override
    public void actionPerformed(ActionEvent e) {
        //������ ��� ������, �� ������� ������
        if (e.getActionCommand().equals("������")) {
            try {
                //��������� ������
                kvartira();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "��������� ������������ �����");
            }

        }else{
            //������� ��� ����
            for(int i=0; i<arrTf.length; i++){
                arrTf[i].setText("");
            }
        }

    }

}
