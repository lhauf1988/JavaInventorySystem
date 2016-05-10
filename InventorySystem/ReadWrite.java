// ClassName........: ReadWrite.java
// Developed By.....: Andrew Clelland
// Week.............: Week 5
// Date Created.....: 8/18/2015
// Purpose..........: Class for read/write to .dat file for drum storage team project

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWrite extends TmpDrum
{
    private DataInputStream istream;
    private String inputFileName = "drum.dat";
    private ArrayList<TmpDrum> drumList;
    private int curPos = 0;
    private DataOutputStream ostream;
    private String outputFileName = "drum.dat";
    
    
    //Creates new form DrumRead
    public void drumRead() 
    {
//        initComponents();
        preInitRead();
    }
    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
//    private void initComponents() {
//
//        txtSize = new javax.swing.JTextField();
//        lblSize = new javax.swing.JLabel();
//        txtManufacturer = new javax.swing.JTextField();
//        txtColor = new javax.swing.JTextField();
//        lblManufacturer = new javax.swing.JLabel();
//        lblColor = new javax.swing.JLabel();
//        btnPrevious = new javax.swing.JButton();
//        btnExit = new javax.swing.JButton();
//        btnNext = new javax.swing.JButton();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setTitle("Read Orders");
//
//        txtSize.setEditable(false);
//
//        lblSize.setText("Size");
//
//        txtManufacturer.setEditable(false);
//
//        txtColor.setEditable(false);
//
//        lblManufacturer.setText("Manufacturer:");
//
//        lblColor.setText("Color");
//
//        btnPrevious.setText("< Previous");
//        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnPreviousActionPerformed(evt);
//            }
//        });
//
//        btnExit.setText("Exit");
//        btnExit.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnExitActionPerformed(evt);
//            }
//        });
//
//        btnNext.setText("Next >");
//        btnNext.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnNextActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//                    .addGroup(layout.createSequentialGroup()
//                        .addGap(53, 53, 53)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(lblColor)
//                            .addComponent(lblManufacturer)
//                            .addComponent(lblSize))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                            .addComponent(txtSize)
//                            .addComponent(txtColor)
//                            .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
//                        .addGap(35, 35, 35))
//                    .addGroup(layout.createSequentialGroup()
//                        .addGap(32, 32, 32)
//                        .addComponent(btnPrevious)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(btnNext)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                        .addComponent(btnExit)))
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(42, 42, 42)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(lblSize)
//                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(18, 18, 18)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(lblColor)
//                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(18, 18, 18)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(lblManufacturer)
//                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(30, 30, 30)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(btnPrevious)
//                    .addComponent(btnExit)
//                    .addComponent(btnNext))
//                .addContainerGap(26, Short.MAX_VALUE))
//        );
//
//        pack();
//    }// </editor-fold>                        

    public void prevousRecord() 
    {
        System.out.println("prevousRecord: " + curPos);
        if (this.drumList.isEmpty()) 
        {
            System.err.println("The List is empty");
            return;
        }
        if (curPos <= 0) 
        {
            System.err.println("Beginning of the List ... ");
            return;
        }
        curPos--;
        readData(curPos);
    }

    public void nextRecord() 
    {
        if (this.drumList.isEmpty()) 
        {
            System.err.println("The List is empty");
            return;
        }
        if (curPos >= this.drumList.size() - 1) 
        {
            System.err.println("End of the List ... ");
            return;
        }
        curPos += 1;
        readData(curPos);
    }
    
    public void searchRecord() 
    {
        String viewId;
        Scanner view = new Scanner(System.in);
        System.out.print("Please enter the Drum ID you wish to view: ");
        viewId = view.next();
        drumList.contains(view);
        if (this.drumList.isEmpty()) 
        {
            System.err.println("The List is empty");
            return;
        }
        
        curPos += 1;
        readData(curPos);
    }

    private void readData(int pIndex) 
    {

        if (this.drumList.isEmpty()) 
        {
            System.err.println("The List is empty");
            return;
        }
        try 
        {

            TmpDrum curDrum = this.drumList.get(pIndex);
            
            curDrum.getDrumSerial();
            curDrum.getMaterial();
            Double.toString(curDrum.getWeight());
            curDrum.getStatus();

        } 
        catch (Exception err) 
        {
            System.err.println("General Error: " + err.getMessage());
            System.exit(1);
        }
    }

    private void preInitRead() 
    {
        // Reading Data from File and populating the ArrayList
        //
        try 
        {
            istream = new DataInputStream(new FileInputStream(inputFileName));
//            drumList = new ArrayList<TmpDrum>();
            while (true) 
            {
                // you need to keep this in a loop otherwise it will overwrite the previous data
                //
                TmpDrum storeDrum = new TmpDrum();    // Very Important

                storeDrum.setDrumSerial(istream.readUTF());
                storeDrum.setMaterial(TmpDrum.CATEGORY.valueOf(istream.readUTF()));
                storeDrum.setWeight(Double.parseDouble(istream.readUTF()));

                // Adding to Array List
                //
                drumList.add(storeDrum);
            }

        } 
        catch (EOFException eof) 
        {
            System.out.println(" >> Normal program termination.");
            System.out.println("Array List: " + drumList.size());
            for (int i = 0; i < this.drumList.size(); i++) 
            {
                TmpDrum curDrum = drumList.get(i);

                System.out.print("Current List [" + i + "]: ");
                System.out.println(" Drum ID: \f" + curDrum.getDrumSerial() + "\f\f Material: \f" + curDrum.getMaterial() + "\f\f Kg: \f" + curDrum.getWeight() + "\f\f" + curDrum.getStatus());
            }
            // Display the first record if the List is not Empty
            //
            if (!this.drumList.isEmpty()) 
            {
                this.readData(0);
            }
        } 
        catch (FileNotFoundException noFile) 
        {
            System.err.println("File not found! " + noFile);
        } 
        catch (IOException io) 
        {
            System.err.println("I/O error occurred: " + io);
        } 
        catch (Throwable anything) 
        {
            System.err.println("Abnormal exception caught !: " + anything);
        } 
        finally 
        {
            if (istream != null) 
            {
                try 
                {
                    istream.close();
                } 
                catch (IOException ignored) 
                {
                    System.err.println("Error closing file: " + ignored.getMessage());
                    System.exit(-1);
                }
            }
        }
    }
    /** Creates new form DrumWrite */
    public void drumWrite() 
    {
//        initComponents();
        preInitWrite ();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
//    private void initComponents() {
//
//        lblSize = new javax.swing.JLabel();
//        txtSize = new javax.swing.JTextField();
//        lblColor = new javax.swing.JLabel();
//        lblManufacturer = new javax.swing.JLabel();
//        txtColor = new javax.swing.JTextField();
//        txtManufacturer = new javax.swing.JTextField();
//        btnAdd = new javax.swing.JButton();
//        btExit = new javax.swing.JButton();
//        btnSave = new javax.swing.JButton();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setTitle("Enter Tee Shirt Order");
//
//        lblSize.setText("Size:");
//
//        lblColor.setText("Color:");
//
//        lblManufacturer.setText("Manufacturer:");
//
//        btnAdd.setText("Add");
//        btnAdd.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnAddActionPerformed(evt);
//            }
//        });
//
//        btExit.setText("Exit");
//        btExit.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btExitActionPerformed(evt);
//            }
//        });
//
//        btnSave.setText("Save");
//        btnSave.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnSaveActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(53, 53, 53)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(lblColor)
//                    .addComponent(lblManufacturer)
//                    .addComponent(lblSize))
//                .addGap(18, 18, 18)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(txtSize)
//                    .addComponent(txtColor)
//                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addContainerGap())
//            .addGroup(layout.createSequentialGroup()
//                .addGap(23, 23, 23)
//                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addComponent(btnSave)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addComponent(btExit)
//                .addGap(22, 22, 22))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(42, 42, 42)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(lblSize)
//                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(18, 18, 18)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(lblColor)
//                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(18, 18, 18)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(lblManufacturer)
//                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(btnAdd)
//                    .addComponent(btExit)
//                    .addComponent(btnSave))
//                .addGap(26, 26, 26))
//        );
//
//        pack();
//    }// </editor-fold>                        
    //method for writing input to .dat
    public void writeToFile ()
    {
        try
        {
            
            if (drumList.isEmpty())
            {
                System.out.println("List is Empty .. Nothing to Save");
                System.exit(0);
            }        
        } 
        catch (NullPointerException err1) 
        {
            System.err.println("No Data occurred: " + err1.getMessage());
            System.exit(0);
        } 
        catch (Exception err) 
        {
            System.err.println("I/O error occurred: " + err.getMessage());
            System.exit(0);
        }
        
        System.out.println("Array List: " + drumList.size());
        for (int i = 0; i < this.drumList.size(); i++) 
        {
            TmpDrum curDrum = drumList.get(i);

            System.out.print("Current List [" + i + "]: \f");
            System.out.println(" Drum ID: \f" + curDrum.getDrumSerial()+ " Material: \f" + curDrum.getMaterial() + " \f" + curDrum.getWeight() + " kg \f" + curDrum.getStatus());
        }

        try
        {
            ostream = new DataOutputStream(new FileOutputStream(outputFileName));
        }
        catch(IOException err1)
        {
            System.err.println("File not opened: " + err1.getMessage());
            System.exit(1);
        }

        try
        {
            for (int i = 0; i < this.drumList.size(); i++) 
            {
                TmpDrum curDrum = drumList.get(i);               
                
                ostream.writeUTF(curDrum.getDrumSerial());
                ostream.writeUTF(curDrum.getMaterial().toString());
                ostream.writeUTF(Double.toString(curDrum.getWeight()));
                ostream.writeUTF(curDrum.getStatus());
            }
            ostream.close();
        }
        catch(IOException err)
        {
                System.err.println("Error writing file: " + err.getMessage());
                System.exit(1);
        } 
        finally 
        {
            if (ostream != null) 
            {
                try 
                {
                    ostream.close();
                } 
                catch (IOException ignored) 
                {
                    System.err.println("Error closing file: " + ignored.getMessage());
                    System.exit(-1);
                }
            }
        }
    }

    public void addToList ()
    {
        TmpDrum.CATEGORY vM;
        String vS;
        double vW;
        Scanner adder = new Scanner(System.in);
        ArrayList<TmpDrum> addDrum = new ArrayList<TmpDrum>(); 
        
        System.out.print("Please enter the drum ID: ");
        vS = adder.next();
        System.out.print("Please enter the material going in the drum: ");
        vM = TmpDrum.CATEGORY.valueOf(adder.next());
        System.out.print("Please enter the weight you wish to put in the drum: ");
        vW = adder.nextDouble();
        try 
        {
        TmpDrum adding = new TmpDrum();    // Very Important

        adding.setDrumSerial(vS);
        adding.setMaterial(vM);
        adding.setWeight(vW);

        // Adding to Array List
        //
        drumList.add(adding);
        } 
        catch (NullPointerException err1) 
        {
            System.err.println("Null Data occurred: " + err1.getMessage());
        } 
        catch (Exception err) 
        {
            System.err.println("I/O error occurred: " + err.getMessage());
        }
        adder.close();
    }
    
    public void removeFromList ()
    {        
        String vS;
        Scanner remover = new Scanner(System.in);
        
        System.out.print("Please enter the drum ID you wish to remove: ");
        vS = remover.next();        
        try 
        {

        // removing from Array List
        //
        drumList.remove(vS);
        } 
        catch (NullPointerException err1) 
        {
            System.err.println("Null Data occurred: " + err1.getMessage());
        } 
        catch (Exception err) 
        {
            System.err.println("I/O error occurred: " + err.getMessage());
        }
        remover.close();
    }

    public void preInitWrite ()
    {
        drumList = new ArrayList<TmpDrum>();    // Very Important
    }
    
}
