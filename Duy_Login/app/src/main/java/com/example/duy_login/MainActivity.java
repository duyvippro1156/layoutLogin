package com.example.duy_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editUser, editPassword;
    Button btnDangnhap, btnDangky, btnThoat;
    String taikhoan, matkhau;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        ControllButton();
    }

    private void anhxa() {
        editUser = (EditText) findViewById(R.id.textuser);
        editPassword = (EditText) findViewById(R.id.textpass);
        btnDangnhap = (Button) findViewById(R.id.buttondangnhap);
        btnDangky = (Button) findViewById(R.id.buttondangky);
        btnThoat = (Button) findViewById(R.id.buttonthoat);
    }

    private void ControllButton() {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog);
                builder.setTitle("Bạn có thoát app hay không");
                builder.setMessage("Lựa chọn để để xác nhận!");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setCancelable(false);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
            }
        });

        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Mở hộp thoại");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.activity_dangky);
                final EditText editTk = (EditText) dialog.findViewById(R.id.edittk);
                final EditText editMk = (EditText) dialog.findViewById(R.id.editmk);
                Button btnDk = (Button) dialog.findViewById(R.id.btndangky);
                Button bthHuy = (Button) dialog.findViewById((R.id.btnhuy));
                btnDk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        taikhoan = editTk.getText().toString().trim();
                        matkhau = editMk.getText().toString().trim();

                        editUser.setText(taikhoan);
                        editPassword.setText(matkhau);

                        dialog.cancel();
                    }
                });
                bthHuy.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                }));
                dialog.show();
            }
        });
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editUser.getText().length() != 0 && editPassword.getText().length() != 0) {
                    if (editUser.getText().toString().equals(taikhoan) && editPassword.getText().toString().equals(matkhau)) {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    } else if (editUser.getText().toString().equals("DUY") && editPassword.getText().toString().equals("123")) {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Bạn phải nhập đủ thông tin cần thiết", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}