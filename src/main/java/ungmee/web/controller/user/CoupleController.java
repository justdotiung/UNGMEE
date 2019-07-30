package ungmee.web.controller.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller("UserCoupleController")
@RequestMapping("/user/couple/")
public class CoupleController {
	
	@GetMapping("index")
	public String index() {
		return "user/couple/index";
	}
	@GetMapping("detail")
	private String detail() {
		return "user/couple/detail";
	}
	@GetMapping("reg")
	private String reg() {
		return "user/couple/reg";
	}
	@PostMapping("reg")
	private String postReg() {
		return "redirect:index";
	}
	@RequestMapping("delete")
	private String delete() {
		return "redirect:index";
	}
	
	@GetMapping("edit")
	public String edit(Model model) {
		return "user/couple/edit";
	}

	@PostMapping("edit")
	public String edit(MultipartFile file, HttpServletRequest request, Model model) throws IOException {
		String urlPath = "/upload";
		String path = request.getServletContext().getRealPath(urlPath);

		System.out.println(path);

		// 2. ���ε�� ���ϸ� ���
		String fileName = file.getOriginalFilename();// filePart.getSubmittedFileName();

		// 3. ��� ������ �ֱ�
		String filePath = path + File.separator + fileName; // d:\aa + "bb.jpg" -> d:\aabb.jpg

		System.out.println(filePath);

		// 4. ��ΰ� ���ٴ� ���� ����
		File pathFile = new File(path);
		if (!pathFile.exists()) // �������� ������
			pathFile.mkdirs();// �������ּ���.

		// 5. ���������� �������� �迭�� �޴´�
		// ������ js�� �̿��ϱ⶧���� �񵿱����κ����� ���Ͼ��ε带 ���� ����°��� Ʈ�����̴�
		File sameFile = new File(filePath);
		System.out.println(sameFile);
		if (sameFile.exists()) {

			int n = fileName.lastIndexOf("."); // fileName=hello.jpg n =?, name= , suffix,
			String name = fileName.substring(0, n); //
			String suffix = fileName.substring(n);

			fileName = name + "(" + 1 + ")" + suffix;
		}

		InputStream fis = file.getInputStream();// filePart.getInputStream();
		OutputStream fos = new FileOutputStream(filePath);

		byte[] buf = new byte[1024];
		int size = 0;
		while ((size = fis.read(buf)) != -1)
			fos.write(buf, 0, size);

		fis.close();
		fos.close();

		model.addAttribute("f", filePath);

		return "user/couple/edit";
	}



}
