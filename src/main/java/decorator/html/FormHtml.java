package decorator.html;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "action",
        "method",
        "strong",
        "input",
        "button"
})
@XmlRootElement(name = "form")
public class FormHtml {

    @XmlAttribute
    private String action;

    @XmlAttribute
    private String method;

    private String strong;

    private List<InputHtml> input;

    private ButtonHtml button;

}
