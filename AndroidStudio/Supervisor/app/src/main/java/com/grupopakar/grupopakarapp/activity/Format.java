//package com.grupopakar.grupopakarapp.activity;
//
//
//import android.view.View;
//
//import com.grupopakar.grupopakarapp.R;
//
//public class Format extends Activity {
//    private Uri mImageCaptureUri;
//    private ImageView mImageView;
//    private static final int PICK_FROM_CAMERA = 1;
//    private static final int PICK_FROM_FILE = 2;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//
//        final String[] items = new String[]{"From Camera", "From SD Card"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, items);
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Select Image");
//        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
//
//            public void onClick(DialogInterface dialog, int item) {
//                if (item == 0) {
//                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    File file = new File(Environment.getExternalStorageDirectory(), "tmp_avatar_" + String.valueOf(System.currentTimeMillis()) + ".jpg");
//                    mImageCaptureUri = Uri.fromFile(file);
//                    try {
//                        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
//                        intent.putExtra("return-data", true);
//                        startActivityForResult(intent, PICK_FROM_CAMERA);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    dialog.cancel();
//                } else {
//                    Intent intent = new Intent();
//                    intent.setType("image/*");
//                    intent.setAction(Intent.ACTION_GET_CONTENT);
//                    startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_FILE);
//                }
//            }
//        });
//
//
//        final AlertDialog dialog = builder.create();
//        mImageView = (ImageView) findViewById(R.id.iv_pic);
//        ((Button) findViewById(R.id.btn_choose)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.show();
//            }
//        });
//
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode != RESULT_OK) return;
//        Bitmap bitmap = null;
//        String path = "";
//        if (requestCode == PICK_FROM_FILE) {
//            mImageCaptureUri = data.getData();
//            path = getRealPathFromURI(mImageCaptureUri); // From Gallery if (path == null) path = mImageCaptureUri.getPath(); // From File Manager if (path != null) bitmap = BitmapFactory.decodeFile(path); } else { path = mImageCaptureUri.getPath(); bitmap = BitmapFactory.decodeFile(path); } mImageView.setImageBitmap(bitmap); } public String getRealPathFromURI(Uri contentUri) { String [] proj = {MediaStore.Images.Media.DATA}; Cursor cursor = managedQuery( contentUri, proj, null, null,null); if (cursor == null) return null; int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA); cursor.moveToFirst(); return cursor.getString(column_index); } }
//        }
//
//    }
//}
//
//    //=========================
//
//
//    private void openFile(File url) {
//        try {
//            Uri uri = Uri.fromFile(url);
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            if (url.toString().contains(".doc") || url.toString().contains(".docx")) {
//                //Word document
//                intent.setDataAndType(uri, "application/msword");
//            } else if (url.toString().contains(".pdf")) {
//                //PDF file
//                intent.setDataAndType(uri, "application/pdf");
//            } else if (url.toString().contains(".ppt") || url.toString().contains(".pptx")) {
//                //Powerpoint file
//                intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
//            } else if (url.toString().contains(".xls") || url.toString().contains(".xlsx")) { /
//                //Excel file
//                intent.setDataAndType(uri, "application/vnd.ms-excel");
//            } else if (url.toString().contains(".zip") || url.toString().contains(".rar")) {
//                //WAV audio file
//                intent.setDataAndType(uri, "application/x-wav");
//            } else if (url.toString().contains(".rtf")) {
//                //RTF file
//                intent.setDataAndType(uri, "application/rtf");
//            } else if (url.toString().contains(".wav") || url.toString().contains(".mp3")) {
//                //WAV audio file
//                intent.setDataAndType(uri, "audio/x-wav");
//            } else if (url.toString().contains(".gif")) {
//                //GIF file
//                intent.setDataAndType(uri, "image/gif");
//            } else if (url.toString().contains(".jpg") || url.toString().contains(".jpeg") || url.toString().contains(".png")) {
//                //JPG file
//                intent.setDataAndType(uri, "image/jpeg");
//            } else if (url.toString().contains(".txt")) {
//                //Text file
//                intent.setDataAndType(uri, "text/plain");
//            } else if (url.toString().contains(".3gp") || url.toString().contains(".mpg") || url.toString().contains(".mpeg") || url.toString().contains(".mpe") || url.toString().contains(".mp4") || url.toString().contains(".avi")) {
//                //Video files
//                intent.setDataAndType(uri, "video/*");
//            } else {
//                intent.setDataAndType(uri, "*/*");
//            } intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent);
//        } catch (ActivityNotFoundException e) {
//            Toast.makeText(context, "No application found which can open the file", Toast.LENGTH_SHORT).show();
//        }
//    }
