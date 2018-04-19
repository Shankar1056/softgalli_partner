package softgalli.partner.retrofit;


import softgalli.partner.model.SchoolListModel;
import softgalli.partner.model.StuTeaModel;

/**
 * Created by Shankar on 1/27/2018.
 */

public interface ServiceMethods {
    void addteacher(String teacher_id, String name, String qualification, String mobile_number, String alternate_number, String email_id,
                    String classteacher_for, String joining_date, String address, DownlodableCallback<StuTeaModel> callback);
    void addstudent(String regestration_id, String name, String email, String mobile, String clas, String sec,
                    String admission_date, String residential_address, DownlodableCallback<StuTeaModel> callback);

    void allschool(DownlodableCallback<SchoolListModel> callback);
}
