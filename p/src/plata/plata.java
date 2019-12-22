package plata;
//добавляем библиотеки для работы с текстовыми полями, метками,
//для создания графического окна
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

//Главный класс, реализующий интерфейс ActionListener
//Интерфейс нужен для обработки события нажатия на кнопку
public class plata implements ActionListener{
    JFrame frame = new JFrame("Кварплата"); //главное окно
    JPanel panelLeft = new JPanel(); //панель с метками
    JPanel panelRight = new JPanel(); //панель с текстовыми полями
    JPanel panelBottom = new JPanel(); //панель с кнопками
    public JTextField[] arrTf = new JTextField[18];//массив текстовых полей

    //конструктор
    public plata(){
        //устанавливаем менеджер компоновки для панели с метками
        //делаем выравнивание по вертикали
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        //устанавлиаем  размер 250 на 300 пикселей
        panelLeft.setPreferredSize(new Dimension(250, 300));

        //устанавливаем менеджер компоновки для панели с текстовыми полями
        //делаем выравнивание по вертикали
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        //устанавливаем  размер 130 на 300 пикселей
        panelRight.setPreferredSize(new Dimension(130,300));

        //добавлям метки через метод addLabel
        addLabel(panelLeft, "Тариф на холодную воду:", Color.RED);
        addLabel(panelLeft, "Тариф на горячую воду:", Color.RED);
        addLabel(panelLeft, "Тариф на свет:", Color.RED);
        addLabel(panelLeft, "Тариф на газ:", Color.RED);
        addLabel(panelLeft, "Количество проживающих:", Color.RED);
        addLabel(panelLeft, "Объем потраченного газа:", Color.RED);
        addLabel(panelLeft, "Объем потраченной горячей воды:", Color.RED);
        addLabel(panelLeft, "Объем потраченной холодной воды:", Color.RED);
        addLabel(panelLeft, "Объем потраченного света:", Color.RED);
        addLabel(panelLeft, "Коммунальные услуги:", Color.RED);
        addLabel(panelLeft, "Долг за прошлый месяц:", Color.RED);
        addLabel(panelLeft, "Переплата с прошлого месяца:", Color.RED);
        addLabel(panelLeft, "Подсчет холодной воды:", Color.BLUE);
        addLabel(panelLeft, "Подсчет горячей воды:", Color.BLUE);
        addLabel(panelLeft, "Подсчет газа:", Color.BLUE);
        addLabel(panelLeft, "Подсчет света:", Color.BLUE);
        addLabel(panelLeft, "Подсчет коммунальных услуг:", Color.BLUE);
        addLabel(panelLeft, "Общая сумма:", Color.BLUE);
        //добавляем текстовые поля через цикл и записываем их в массив
        for(int i=0; i<arrTf.length; i++){
            if(arrTf.length>=0){
                //записываем ссылку из метода в массив для дальнейшей работы с
                //тестовым полем
                arrTf[i] = addTextField(panelRight);}

        }


        //добавляем кнопки расчета и сброса
        JButton calc = addButton(panelBottom, "Расчет");
        //добавляем слушатель на событие нажатия
        calc.addActionListener(this);
        JButton reset = addButton(panelBottom, "Сброс");
        //добавляем слушатель на событие нажатия
        reset.addActionListener(this);


        //делаем главную форму видимой
        frame.setVisible(true);
        //устанавливаем действие при нажатии на крестик - завершение приложения
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //устанавливаем начальное положение относительно центра экрана (по центру)
        frame.setLocationRelativeTo(null);
        //Устанавливаем размер главного окна(400 на 450)
        frame.setSize(400,450);
        //Добавляем метку с информацией к работе в самый верх окна
        JLabel top = new JLabel("Красные поля являются обязательными для заполнения");
        //устанавливаем выравнивание текста в метке по центру
        top.setHorizontalAlignment(JLabel.CENTER);

        //добавляем панели на клавное окно
        frame.add(top, BorderLayout.NORTH);
        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(panelRight, BorderLayout.EAST);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.setResizable(false); //запрещаем изменение размеров главного окна

    }


    //метод добавления текстовых меток
    public void addLabel(JComponent container, String name, Color color){
        //создаем тестовую метку с именем name
        JLabel lb = new JLabel(name);
        //устанавливаем максимально допустимый размер
        lb.setMaximumSize(new Dimension(400,20));
        //устанавливаем цвета текста
        lb.setForeground(color);
        //устанавливаем выравнивание по правому краю
        lb.setHorizontalAlignment(JLabel.RIGHT);
        //добавляем рамку
        lb.setBorder(new EtchedBorder());
        //Добавляем текстовую метку в панель
        container.add(lb);
    }

    //метод добавления текстовых полей
    public JTextField addTextField(JComponent container){
        //Создаем текстовое поле
        JTextField tf = new JTextField();
        //устанавливаем его максимально допустимый размер
        tf.setMaximumSize(new Dimension(150,20));
        //добавляем текстовое поле на панель
        container.add(tf);
        //возвращаем ссылку на текстовое поле
        return tf;
    }

    //метод добавления кнопок
    public JButton addButton(JComponent container, String name){
        //Создаем кнопку
        JButton btn = new JButton(name);
        //Устанавливаем максимально допустимый размер
        btn.setMaximumSize(new Dimension(100,20));
        //Выравниваем по горизонтали по центру
        btn.setHorizontalAlignment(JButton.CENTER);

        //добавляем кнопку на панель
        container.add(btn);
        //возвращаем ссылку на кнопку
        return btn;
    }


    //метод расчета
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
            arrTf[12].setText(String.format("%.2f", q1)); //выводим цену в 13 т.п.
        }
        else {
            arrTf[12].setText(" "); //выводим цену в 13 т.п.
        }
        if ((h != 0) & (vh != 0)) {
            q2 = h*vh; //Cena na hot water
            arrTf[13].setText(String.format("%.2f", q2)); //выводим цену в 14 т.п.
        }
        else {
            arrTf[13].setText(" "); //выводим цену в 14 т.п.
        }
        if ((g != 0) & (vg != 0)) {
            q3 = g*vg; //Cena na gas
            arrTf[14].setText(String.format("%.2f", q3)); //выводим цену в 15 т.п.
        }
        else {
            arrTf[14].setText(" "); //выводим цену в 15 т.п.
        }
        if ((s != 0) & (vs != 0)) {
            q4 = s*vs; //Cena na svet
            arrTf[15].setText(String.format("%.2f", q4)); //выводим цену в 16 т.п.
        }
        else {
            arrTf[15].setText(" "); //выводим цену в 16 т.п.
        }
        if ((k != 0) & (u != 0)) {
            q5 = k*u; //Cena na kommunalnye uslugy
            arrTf[16].setText(String.format("%.2f", q5)); //выводим цену в 17 т.п.
        }
        else {
            arrTf[16].setText(" "); //выводим цену в 17 т.п.
        }
        if ((q1 != 0) || (q2 != 0) || (q3 != 0) || (q4 != 0) || (q5 != 0) || (d >= 0) || (p >= 0)) {
            summa = q1+q2+q3+q4+q5+d-p; //summa
            arrTf[17].setText(String.format("%.2f", summa));  //выводим цену в 18 т.п.
        }
        else {
            arrTf[17].setText(" ");  //выводим цену в 18 т.п.
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

    //Метод обработки события нажатия на кнопку
    @Override
    public void actionPerformed(ActionEvent e) {
        //узнаем имя кнопки, на которую нажали
        if (e.getActionCommand().equals("Расчет")) {
            try {
                //выполняем расчет
                kvartira();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            }

        }else{
            //очищаем все поля
            for(int i=0; i<arrTf.length; i++){
                arrTf[i].setText("");
            }
        }

    }

}
