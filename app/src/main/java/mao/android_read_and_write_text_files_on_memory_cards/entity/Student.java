package mao.android_read_and_write_text_files_on_memory_cards.entity;

import java.io.Serializable;

/**
 * Project name(项目名称)：android_read_and_write_text_files_on_memory_cards
 * Package(包名): mao.android_read_and_write_text_files_on_memory_cards.entity
 * Class(类名): Student
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/27
 * Time(创建时间)： 20:34
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class Student implements Serializable
{
    /**
     * id
     */
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 重量
     */
    private Float weight;


    /**
     * Instantiates a new Student.
     */
    public Student()
    {
    }

    /**
     * Instantiates a new Student.
     *
     * @param id     the id
     * @param name   the name
     * @param age    the age
     * @param weight the weight
     */
    public Student(Long id, String name, Integer age, Float weight)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public Integer getAge()
    {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(Integer age)
    {
        this.age = age;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public Float getWeight()
    {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(Float weight)
    {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Student student = (Student) o;

        if (getId() != null ? !getId().equals(student.getId()) : student.getId() != null)
        {
            return false;
        }
        if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null)
        {
            return false;
        }
        if (getAge() != null ? !getAge().equals(student.getAge()) : student.getAge() != null)
        {
            return false;
        }
        return getWeight() != null ? getWeight().equals(student.getWeight()) : student.getWeight() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        result = 31 * result + (getWeight() != null ? getWeight().hashCode() : 0);
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("id：").append(id).append('\n');
        stringbuilder.append("name：").append(name).append('\n');
        stringbuilder.append("age：").append(age).append('\n');
        stringbuilder.append("weight：").append(weight).append('\n');
        return stringbuilder.toString();
    }
}
