package mao.android_read_and_write_text_files_on_memory_cards.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Project name(项目名称)：android_read_and_write_text_files_on_memory_cards
 * Package(包名): mao.android_read_and_write_text_files_on_memory_cards.io
 * Class(类名): ObjectFileIO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/27
 * Time(创建时间)： 20:36
 * Version(版本): 1.0
 * Description(描述)： 以前学java se 时写的，有些东西不能用
 */

public class ObjectFileIO
{
    private static boolean isWarning = true;

    public static void setIsWarning(boolean isWarning)
    {
        ObjectFileIO.isWarning = isWarning;
    }

    /**
     * 将对象写入到文件里
     *
     * @param object 要写入的对象
     * @param path   文件的路径
     * @return 写入成功，则返回true，写入失败，则返回false
     */
    public static boolean write(Object object, String path)
    {
        File file = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try                                  //文件流打开，文件读写
        {
            file = new File(path);
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            return true;
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            if (isWarning)
            {
                //Toolkit.getDefaultToolkit().beep();
            }
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.getMessage());
            return false;
        }
        catch (Exception e)                  //其它异常
        {
            if (isWarning)
            {
                //Toolkit.getDefaultToolkit().beep();
            }
            e.printStackTrace();
            return false;
        }
        finally
        {
            try                              //关闭流
            {
                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                if (isWarning)
                {
                    //Toolkit.getDefaultToolkit().beep();
                }
                System.err.println("文件已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                if (isWarning)
                {
                    //Toolkit.getDefaultToolkit().beep();
                }
                e.printStackTrace();
            }
            try                              //关闭流
            {
                if (objectOutputStream != null)
                {
                    objectOutputStream.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                if (isWarning)
                {
                    //Toolkit.getDefaultToolkit().beep();
                }
                System.err.println("文件已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                if (isWarning)
                {
                    //Toolkit.getDefaultToolkit().beep();
                }
                e.printStackTrace();
            }
        }
    }


    /**
     * 从文件里读取对象
     *
     * @param path 文件的路径
     * @return Object 对象。如果读取失败，则返回null
     */
    public static Object read(String path)
    {
        File file = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try                                  //文件流打开，文件读写
        {
            file = new File(path);
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            if (isWarning)
            {
                //Toolkit.getDefaultToolkit().beep();
            }
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.getMessage());
            return null;
        }
        catch (Exception e)                  //其它异常
        {
            if (isWarning)
            {
                //Toolkit.getDefaultToolkit().beep();
            }
            e.printStackTrace();
            return null;
        }
        finally
        {
            try                              //关闭流
            {
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                if (isWarning)
                {
                    //Toolkit.getDefaultToolkit().beep();
                }
                System.err.println("文件已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                if (isWarning)
                {
                    //Toolkit.getDefaultToolkit().beep();
                }
                e.printStackTrace();
            }

            try                              //关闭流
            {
                if (objectInputStream != null)
                {
                    objectInputStream.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                if (isWarning)
                {
                    //Toolkit.getDefaultToolkit().beep();
                }
                System.err.println("文件已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                if (isWarning)
                {
                    //Toolkit.getDefaultToolkit().beep();
                }
                e.printStackTrace();
            }
        }
    }

    /**
     * 从文件里读取对象
     *
     * @param path  文件的路径
     * @param clazz 要返回的的对象的类的字节码
     * @param <T>   泛型T
     * @return 泛型对象，如果读取失败，则返回null
     */
    @SuppressWarnings("all")
    public static <T> T read(String path, Class<T> clazz)
    {
        T t = null;
        File file = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try                                  //文件流打开，文件读写
        {
            file = new File(path);
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            t = (T) objectInputStream.readObject();
            return t;
        }
        catch (FileNotFoundException e)      //文件未找到
        {
            if (isWarning)
            {
                //Toolkit.getDefaultToolkit().beep();
            }
            System.err.println("文件未找到！！！  " + "\n错误内容：" + e.getMessage());
            return null;
        }
        catch (Exception e)                  //其它异常
        {
            if (isWarning)
            {
                //Toolkit.getDefaultToolkit().beep();
            }
            e.printStackTrace();
            return null;
        }
        finally
        {
            try                              //关闭流
            {
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                if (isWarning)
                {
                    //Toolkit.getDefaultToolkit().beep();
                }
                System.err.println("文件已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                if (isWarning)
                {
                    //Toolkit.getDefaultToolkit().beep();
                }
                e.printStackTrace();
            }

            try                              //关闭流
            {
                if (objectInputStream != null)
                {
                    objectInputStream.close();
                }
            }
            catch (NullPointerException e)    //空指针异常
            {
                if (isWarning)
                {
                    //Toolkit.getDefaultToolkit().beep();
                }
                System.err.println("文件已经被关闭，无法再次关闭！！！");
            }
            catch (Exception e)              //其它异常
            {
                if (isWarning)
                {
                    //Toolkit.getDefaultToolkit().beep();
                }
                e.printStackTrace();
            }
        }
    }

}
