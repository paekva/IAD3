package lab.mb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import javax.faces.validator.Validator;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validator")
public class ValidatorY implements Validator
{
    private static final String DOUBLE_PATTERN = "((-|\\+)?[0-9]+(\\.[0-9]+)?)+";
    private final Pattern pattern;

    public ValidatorY()
    {
        pattern = Pattern.compile(DOUBLE_PATTERN);
    }

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
    {
        Matcher matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            FacesMessage msg = new FacesMessage("Неверный формат ввода поля Y");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        else
        {
            String str=value.toString();
            Double y = Double.parseDouble(str);
            if((y<-3)||(y>3))
            {
                FacesMessage msg = new FacesMessage("Введенное значение поля Y не входит в допустимый промежуток значений");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }
}
