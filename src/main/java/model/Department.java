package model;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:9/14/16
 * TIME:3:31 PM
 */

/**
 * 部门信息
 */
public class Department {
    String deptid;//部门ID
    String deptname;//部门名称
    String deptliq;//部门排序
    String parentid;//父部门ID

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptliq() {
        return deptliq;
    }

    public void setDeptliq(String deptliq) {
        this.deptliq = deptliq;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "deptid: " + getDeptid() + "deptname: " + getDeptname();
    }
}
