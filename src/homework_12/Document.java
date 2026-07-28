package homework_12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Программа на вход получает произвольный текст. В этом тексте может быть номер
//документа(один или несколько), емейл и номер телефона. Номер документа в формате:
//xxxx-xxxx-xx, где x - это любая цифра; номер телефона в формате: +(xx)xxxxxxx. Документ
//может содержать не всю информацию, т.е. например, может не содержать номер
//телефона, или другое. Необходимо найти эту информацию и вывести в консоль в
//формате:
//email: teachmeskills@gmail.com
//document number: 1423-1512-51
//и т.д
public class Document {
    public static void main(String[] args) {
        String text = """
                Приветствую! Направляю вам актуальные данные по нашему проекту.\s
                Вчера мы окончательно утвердили и подписали основной документ 1423-1512-51.
                Все финансовые приложения к нему были зафиксированы отдельно в документ 0023-7419-55.
               \s
                Если у вас возникнут срочные вопросы по юридической части, вы можете связаться с нашим юристом.\s
                Его номер телефона: +(29)9991234.\s
                Также контакт технической поддержки на случай сбоев с доступом к системе: +(38)0445552.
               \s
                Официальные сканы документов и ваши замечания присылайте на почту: project-info@company.com,\s
                либо пишите мне напрямую: teachmeskills@gmail.com.\s
                Ответственный менеджер свяжется с вами сразу после проверки архива.""";

        System.out.println("Текст документа:\n"+text);
        System.out.println("-".repeat(90));
        final Pattern documentNumberPattern = Pattern.compile("\\d{4}-\\d{4}-\\d{2}");
        final Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");
        final Pattern phoneNumberPattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");

        String[] phones = findInformation(phoneNumberPattern, text);
        String[] emails = findInformation(emailPattern, text);
        String[] documents = findInformation(documentNumberPattern, text);

        for (String document : documents) {
            System.out.println("document number: " + document);
        }
        for (String email : emails) {
            System.out.println("email: " + email);
        }
        for (String phone : phones) {
            System.out.println("phone number: " + phone);
        }

    }
    public static String[] findInformation(Pattern pattern, String text){
        int count = 0;
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            count++;
        }
        if (count == 0) return new String[0];

        String[] result = new String[count];
        matcher.reset();

        int i = 0;
        while (matcher.find()) {
            result[i] = matcher.group();
            i++;
        }

        return result;
    }
}
