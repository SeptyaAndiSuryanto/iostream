package iostream;

import java.io.*;
public class stream {
	public void unbuffer () throws IOException{
		FileInputStream in = null;
        FileOutputStream out = null;
        long start = System.nanoTime();
        try {
            in = new FileInputStream("code.png");
            out = new FileOutputStream("outcode.png");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
        long finish = System.nanoTime();
        System.out.println("time= "+(finish - start)+ " ns");
		
	}
	
	public void buffer() throws IOException{
		FileInputStream in = null;
		OutputStream out = null;
		BufferedInputStream buin = null;
		BufferedOutputStream buot = null;
		byte[] buf = new byte[999999999];
        long start = System.nanoTime();
		try{
			in = new FileInputStream("code.png");
			buin = new BufferedInputStream(in);
			out = new FileOutputStream("outcodebuff.png");
			buot = new BufferedOutputStream(out);
			int c;
			while ((c=buin.read(buf)) !=-1){
				buot.write(buf, 0, c);
			}
			buot.flush();
			buot.close();
		}finally {
			if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            long finish = System.nanoTime();
            System.out.println("time= "+(finish - start)+ " ns");

		}
	}
	
	 public static void main(String[] args) throws IOException {
		 stream s = new stream();
		 //s.unbuffer();
		 s.buffer();
	}

}
