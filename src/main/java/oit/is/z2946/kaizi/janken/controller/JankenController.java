package oit.is.z2946.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class JankenController {

  /**
   * janken.html を表示します。
   *
   * @return janken.htmlのテンプレート名
   */
  @GetMapping("/janken")
  public String jankenPage() {
    return "janken.html";
  }

  /**
   * index.htmlからのログイン情報を受け取り、jankenページにリダイレクトします。
   *
   * @param userName           フォームから送られてきたユーザ名
   * @param redirectAttributes リダイレクト先に情報を引き継ぐためのオブジェクト
   * @return リダイレクト先のパス
   */
  @PostMapping("/janken/login")
  public String login(@RequestParam("username") String userName, RedirectAttributes redirectAttributes) {
    // リダイレクト先に一時的な属性（Flash Attribute）としてユーザ名を追加
    redirectAttributes.addFlashAttribute("username", userName);

    // /janken へリダイレクト
    return "redirect:/janken";
  }
}
