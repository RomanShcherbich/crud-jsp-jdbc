package decorator.html;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "p",
        "button"
})
@XmlRootElement(name = "td")
public class TdHtml {

    private String p;
    @Builder.Default
    private List<ButtonHtml> button = Arrays.asList(
            ButtonHtml.builder()
                    .button("Edit")
                    .onclick(ButtonHtml.BUTTON_ON_CLICK_ACTION)
                    .build(),
            ButtonHtml.builder()
                    .button("Delete")
                    .onclick(ButtonHtml.BUTTON_ON_CLICK_ACTION)
                    .build());

    public TdHtml(String p) {
        this.p = p;
    }

    public TdHtml(List<ButtonHtml> button) {
        this.button = button;
    }
}
