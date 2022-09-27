package mao.android_read_and_write_text_files_on_memory_cards;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

import mao.android_read_and_write_text_files_on_memory_cards.entity.Student;
import mao.android_read_and_write_text_files_on_memory_cards.io.ObjectFileIO;


/**
 * Class(类名): MainActivity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/27
 * Time(创建时间)： 20:33
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class MainActivity extends AppCompatActivity
{
    /**
     * save按钮
     */
    private Button saveButton;
    /**
     * load按钮
     */
    private Button loadButton;

    /**
     * 学号编辑文本
     */
    private EditText idEditText;

    /**
     * 名称编辑文本
     */
    private EditText nameEditText;

    /**
     * 年龄编辑文本
     */
    private EditText ageEditText;

    /**
     * 体重编辑文本
     */
    private EditText weightEditText;


    /**
     * 标签
     */
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = findViewById(R.id.Button_save);
        loadButton = findViewById(R.id.Button_load);

        idEditText = findViewById(R.id.EditText_id);
        nameEditText = findViewById(R.id.EditText_name);
        ageEditText = findViewById(R.id.EditText_age);
        weightEditText = findViewById(R.id.EditText_weight);

        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                save();
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                load();
            }
        });

        //load();
    }


    /**
     * 保存
     */
    private void save()
    {
        try
        {
            long id = Long.parseLong(idEditText.getText().toString());
            String name = nameEditText.getText().toString();
            int age = Integer.parseInt(ageEditText.getText().toString());
            float weight = Float.parseFloat(weightEditText.getText().toString());

//            SharedPreferences.Editor editor = getSharedPreferences("text", MODE_PRIVATE).edit();
//
//            editor.putLong("id", id);
//            editor.putString("name", name);
//            editor.putInt("age", age);
//            editor.putFloat("weight", weight);
//
//            editor.commit();


            Student student = new Student(id, name, age, weight);
            File file = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);

            boolean b = ObjectFileIO.write(student, file.toString() + "/test.txt");
            if (!b)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("异常")
                        .setMessage("写入失败")
                        .setPositiveButton("确定", null)
                        .create()
                        .show();
                return;
            }

            //异步
            //editor.apply();

            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Log.e(TAG, "save: ", e);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("异常")
                    .setMessage("出现异常，请检查输入\n异常内容为：\n" + e.getMessage())
                    .setPositiveButton("确定", null)
                    .create()
                    .show();
        }


    }

    /**
     * 加载
     */
    private void load()
    {
//        SharedPreferences sharedPreferences = getSharedPreferences("text", MODE_PRIVATE);
//        long id = sharedPreferences.getLong("id", 0);
//        String name = sharedPreferences.getString("name", "");
//        int age = sharedPreferences.getInt("age", 0);
//        float weight = sharedPreferences.getFloat("weight", 0.0f);


        try
        {
            File file = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            Student student = ObjectFileIO.read(file.toString() + "/test.txt", Student.class);

            if (student == null)
            {
                throw new Exception("读取失败");
            }
            Long id = student.getId();
            String name = student.getName();
            Integer age = student.getAge();
            Float weight = student.getWeight();

            idEditText.setText(String.valueOf(id));
            nameEditText.setText(name);
            ageEditText.setText(String.valueOf(age));
            weightEditText.setText(String.valueOf(weight));


            String str = "学号：" + id + "\n姓名：" + name + "\n年龄：" + age + "\n体重："
                    + weight + "\n\n文件路径：" + file.toString() + "/test.txt";
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("读取到的内容")
                    .setMessage(str)
                    .setPositiveButton("确定", null)
                    .create()
                    .show();
        }
        catch (Exception e)
        {
            Log.e(TAG, "save: ", e);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("异常")
                    .setMessage("出现异常，请检查输入\n异常内容为：\n" + e.getMessage())
                    .setPositiveButton("确定", null)
                    .create()
                    .show();
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        save();
    }
}