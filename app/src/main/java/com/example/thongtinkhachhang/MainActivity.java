package com.example.thongtinkhachhang;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    database database;
//    ArrayList<ThongTin> thongTinArrayList;
//    Adapter adapter;
    EditText edtHoTen, edtSdt;
    Button btnThem, btnXem, btnXoa;
    CheckBox cbAnNhe, cbDieuHoa, cbChanMen;
    RadioGroup radioGroupUuTien;
    RadioButton rdNguoiGia;
    RadioButton rdTreNho;
    RadioButton rdCoThai;
    String dichVu = "";
    String uTien = "";
    int idkh = 1  ;
//    String ten, sdt, uuTien, dvThem;
    ThongTin user = new ThongTin();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXA();
        // tạo database thông tin khách hàng
        database = new database(this, "thongtinkhachhang.sql", null,1);

        // TẠO BẢNG THÔNG TIN KHÁCH HÀNG TRONG CƠ SỞ DỮ LIỆU
        database.QueryData("DROP TABLE ThongTinKhachHang");
        database.QueryData("CREATE TABLE IF NOT EXISTS ThongTinKhachHang(Id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                " TenKH VARCHAR(50), Sdt VARCHAR(10), Uutien VARCHAR(20), DvThem VARCHAR(20))");

        //insert data
        // database.QueryData("INSERT INTO ThongTinKhachHang VALUES (null, 'Trần Ngọc Lan', '09678907')");

        // select data
//       GetDataThongTin();
//        radioGroupUuTien.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId){
//                    case R.id.radioButtonnguoiGia:
//                        uTien = rdNguoiGia.getText().toString();
//                        break;
//                    case R.id.radioButtonTreNho:
//                        uTien = rdTreNho.getText().toString();
//                        break;
//                    case R.id.radioButtonCo:
//                        uTien = rdCoThai.getText().toString();
//                        break;
//                }
//            }
//        });

        Them();
       Xem();

    }
    public  void AnhXA(){
        edtHoTen = (EditText) findViewById(R.id.editTextTenKH);
        edtSdt = (EditText) findViewById(R.id.editTextsdtKH);
        btnThem = (Button) findViewById(R.id.buttonThem);
        btnXem = (Button)findViewById(R.id.buttonXem);
        btnXoa = (Button) findViewById(R.id.buttonXoa);
        cbAnNhe = (CheckBox) findViewById(R.id.checkBoxAnNhe);
        cbDieuHoa = (CheckBox) findViewById(R.id.checkBoxDieuHoa);
        cbChanMen = (CheckBox) findViewById(R.id.checkBoxChanMen);
        radioGroupUuTien = (RadioGroup) findViewById(R.id.radioGrouUuTien);
        rdNguoiGia = (RadioButton) findViewById(R.id.radioButtonnguoiGia);
        rdTreNho = (RadioButton) findViewById(R.id.radioButtonTreNho);
        rdCoThai = (RadioButton) findViewById(R.id.radioButtonCo);

    }
    // hàm lấy thông tin
    private void GetDataThongTin(){
        Cursor dataThongTin = database.GetData("SELECT *FROM ThongTinKhachHang");
        while(dataThongTin.moveToNext()){ // di chuyển sang kế bên xem còn ko
            user.setIdKH(Integer.parseInt(dataThongTin.getString(0)));
            user.setTenKH(dataThongTin.getString(1));
            user.setSdt(dataThongTin.getString(2));
            user.setUuTien(dataThongTin.getString(3));
            user.setDvThem(dataThongTin.getString(4));
        }
    }

    // thêm thông tin
    public void Them(){

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cbAnNhe.isChecked()){
                    dichVu += cbAnNhe.getText().toString();
                }
                if (cbChanMen.isChecked()){
                    dichVu += cbChanMen.getText().toString();
                }
                if (cbDieuHoa.isChecked()){
                    dichVu += cbDieuHoa.getText().toString();
                }

                if (rdNguoiGia.isChecked()){
                   // Toast.makeText(MainActivity.this, "Người già", Toast.LENGTH_SHORT).show();
                    uTien = rdNguoiGia.getText().toString();
                }
                if (rdTreNho.isChecked()){
                    uTien = rdTreNho.getText().toString();
                }
                if (rdCoThai.isChecked()){
                    uTien = rdCoThai.getText().toString();
                }

                if(edtHoTen.getText().toString().equals("")||edtSdt.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }if(!edtHoTen.getText().toString().equals(edtHoTen.getText().toString().toUpperCase())){
                    Toast.makeText(MainActivity.this, "Vui lòng viết hoa họ tên", Toast.LENGTH_SHORT).show();
                }
                else {
                    user.setTenKH(edtHoTen.getText().toString());
                    user.setSdt(edtSdt.getText().toString());
                    database.QueryData("INSERT INTO ThongTinKhachHang VALUES (null,'"+ user.getTenKH() +"','"+ user.getSdt() +"', '"+ uTien +"' , '"+ dichVu +"' )");
                    GetDataThongTin();
                }
            }
        });
    }
    public void Xem(){
        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor dataTT = database.GetData("SELECT *FROM ThongTinKhachHang WHERE Id = '" + idkh + "'");

                while (dataTT.moveToNext()){
                    user.setTenKH(dataTT.getString(1));
                    user.setSdt(dataTT.getString(2));
                    user.setUuTien(dataTT.getString(3));
                    user.setDvThem(dataTT.getString(4));
                }

                Toast.makeText(MainActivity.this, "Thông tin khách hàng có id = 0:\nTen:"+user.getTenKH()+"\nSDT:"+user.getSdt(), Toast.LENGTH_LONG).show();
            }

        });
    }
}
