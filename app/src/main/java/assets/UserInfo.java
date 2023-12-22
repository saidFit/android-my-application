package assets;
import android.widget.Button;
import android.widget.EditText;

public class UserInfo {
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private Button buttonSubmit;

    public EditText getEditTextName() {
        return editTextName;
    }

    public void setEditTextName(EditText editTextName) {
        this.editTextName = editTextName;
    }

    public EditText getEditTextPhone() {
        return editTextPhone;
    }

    public void setEditTextPhone(EditText editTextPhone) {
        this.editTextPhone = editTextPhone;
    }

    public EditText getEditTextEmail() {
        return editTextEmail;
    }

    public void setEditTextEmail(EditText editTextEmail) {
        this.editTextEmail = editTextEmail;
    }

    public Button getButtonSubmit() {
        return buttonSubmit;
    }

    public void setButtonSubmit(Button buttonSubmit) {
        this.buttonSubmit = buttonSubmit;
    }
}
