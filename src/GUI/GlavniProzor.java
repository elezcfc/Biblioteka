package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmNew;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenu mnRecintFiles;
	private JMenuItem mntmAbout;
	private JSeparator separator;
	private JPopupMenu popupMenu;
	private JMenuItem mntmNew_1;
	private JMenuItem mntmExit_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {//red gde se registruju dogadjaji koje eventdistatch rasporedjuje
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);//da prozor bude na sredini
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ugasiAplikaciju();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(GlavniProzor.class.getResource("/icons/\u0410\u041A\u041E \u0421\u0418 \u0421\u0420\u0411\u0418\u041D \u041F\u0420\u0410\u0412\u0418.jpg")));
		setTitle("Biblioteka");//konstruktor za dimenzije prozora
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		addPopup(contentPane, getPopupMenu());
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmNew());
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMnRecintFiles());
			mnFile.add(getSeparator());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmNew() {
		if (mntmNew == null) {
			mntmNew = new JMenuItem("New");
			mntmNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//throw new RuntimeException("Greska");prekinula se evtd(eventDispetch nit) i java je automatski kreira ponovo
					try{
						throw new RuntimeException("Greska");
					}catch(Exception e) {
						JOptionPane.showMessageDialog(
								contentPane,
								e.getMessage(),
								"Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				/*
				 * sve aplikacije koriste 2 niti, main i evtd
				 */
			});
			mntmNew.setMnemonic(KeyEvent.VK_N);
			mntmNew.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		}
		return mntmNew;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser fc = new JFileChooser();
					
					int opcija =  fc.showOpenDialog(contentPane);//showSaveDialog, za save as opciju
					
					if(opcija == JFileChooser.APPROVE_OPTION){
						File f = fc.getSelectedFile();
						System.out.println(f.getAbsolutePath());
					}
				}	
			});
			mntmOpen.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ugasiAplikaciju();
				}
			});
			mntmExit.setToolTipText("Gasi program");
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		}
		return mntmExit;
	}
	private JMenu getMnRecintFiles() {
		if (mnRecintFiles == null) {
			mnRecintFiles = new JMenu("Recint files");
		}
		return mnRecintFiles;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(//za obavestajni prozor. Prvi parametar lokacija, drugi tekst, treci naziv prozora, cetvrti ikonica
							contentPane, 
							"Autor: Elez Stefan Verzija: 1.0", 
							"Oprogramu",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmAbout.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
		}
		return mntmAbout;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmNew_1());
			popupMenu.add(getMntmExit_1());
		}
		return popupMenu;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMntmNew_1() {
		if (mntmNew_1 == null) {
			mntmNew_1 = new JMenuItem("New");
		}
		return mntmNew_1;
	}
	private JMenuItem getMntmExit_1() {
		if (mntmExit_1 == null) {
			mntmExit_1 = new JMenuItem("Exit");
			mntmExit_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ugasiAplikaciju();
				}
			});
		}
		return mntmExit_1;
	}
	private void ugasiAplikaciju() {
		int sifra = JOptionPane.showConfirmDialog(
				contentPane, 
				"Da li zaista zelite da izadjete? ",
				"Izlaz",
				JOptionPane.YES_NO_OPTION);
		if(sifra == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
}
