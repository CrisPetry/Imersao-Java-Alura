import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GenerateFigures {

	public void create(InputStream inputStream, String nomeArquivo) throws IOException {

		BufferedImage imgOriginal = ImageIO.read(inputStream);

		int largura = imgOriginal.getWidth();
		int altura = imgOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imgOriginal, 0, 0, null);

		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 72);
		graphics.setFont(fonte);

		graphics.drawString("TESTE", largura / 2 - 100, novaAltura - 100);

		ImageIO.write(novaImagem, "png", new File(nomeArquivo));

	}

}
