package oit.is.z2946.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Modelをインポート
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class JankenController {

  @GetMapping("/janken")
  public String jankenPage() {
    return "janken.html";
  }

  @PostMapping("/janken/login")
  public String login(@RequestParam("username") String userName, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("username", userName);
    return "redirect:/janken";
  }

  /**
   * じゃんけんの対戦処理を行う
   *
   * @param myHand プレイヤーが選んだ手
   * @param model  テンプレートに渡すデータを格納するオブジェクト
   * @return janken.htmlのテンプレート名
   */
  @GetMapping("/janken/play")
  public String play(@RequestParam("myhand") String myHand, Model model) {
    // CPUの手を「グー」に固定
    String cpuHand = "グー";

    // 勝敗判定
    String result;
    if (myHand.equals(cpuHand)) {
      result = "あいこ";
    } else if ((myHand.equals("グー") && cpuHand.equals("チョキ")) ||
        (myHand.equals("チョキ") && cpuHand.equals("パー")) ||
        (myHand.equals("パー") && cpuHand.equals("グー"))) {
      result = "あなたの勝ち！";
    } else {
      result = "あなたの負け...";
    }

    // テンプレートに渡すデータをModelオブジェクトに追加
    model.addAttribute("myHand", myHand);
    model.addAttribute("cpuHand", cpuHand);
    model.addAttribute("result", result);

    // janken.html を表示
    return "janken";
  }
}
