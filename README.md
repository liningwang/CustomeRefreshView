# CustomeRefreshView
扩展Android-PullToRefresh-master，增加可以自己定制刷新头。
用法：

在activity中：
```java
CustomeLoadingLayout layout = new CustomeLoadingLayout(this,Mode.PULL_FROM_START, PullToRefreshBase.Orientation.VERTICAL);
mPullRefreshListView.setCustomAnimateLayout(this,layout);
```
然后定义自己的刷新头：

```java
public class CustomeLoadingLayout extends LoadingLayout {

	static final int ROTATION_ANIMATION_DURATION = 1200;

	private  Animation mRotateAnimation;
	private  Matrix mHeaderImageMatrix;
	private ImageView mHeaderImage;
	private float mRotationPivotX, mRotationPivotY;
	private View view;
	private AnimationDrawable anim;

	public CustomeLoadingLayout(Context context, Mode mode, Orientation scrollDirection) {

		super(context, mode, scrollDirection, null);
		view = LayoutInflater.from(context).inflate(R.layout.pull_to_refresh_header_vertical1,null);
		setInit(view,context,mode,scrollDirection);
		mHeaderImage = (ImageView) view.findViewById(R.id.pull_to_refresh_image1);
		anim = (AnimationDrawable) mHeaderImage.getBackground();
	}

	public void onLoadingDrawableSet(Drawable imageDrawable) {
		if (null != imageDrawable) {
			mRotationPivotX = Math.round(imageDrawable.getIntrinsicWidth() / 2f);
			mRotationPivotY = Math.round(imageDrawable.getIntrinsicHeight() / 2f);
		}
	}

	protected void onPullImpl(float scaleOfLayout) {
		Log.d("wang"," onPullImpl " + scaleOfLayout);
		if(scaleOfLayout > 0.2) {
			mHeaderImage.setBackgroundResource(R.drawable.node_modules_jdreactcorelib_libraries_jdscrollview_images_app_refresh_people_1);
		}
		if(scaleOfLayout > 0.5) {
			mHeaderImage.setBackgroundResource(R.drawable.node_modules_jdreactcorelib_libraries_jdscrollview_images_app_refresh_people_2);
		}
		if(scaleOfLayout > 0.7) {
			mHeaderImage.setBackgroundResource(R.drawable.node_modules_jdreactcorelib_libraries_jdscrollview_images_app_refresh_people_3);

		}
	}

	@Override
	protected void refreshingImpl() {
		Log.d("wang","refreshingImpl");
		mHeaderImage.setBackgroundResource(R.drawable.pro);
		anim = (AnimationDrawable) mHeaderImage.getBackground();
		anim.start();
	}

	@Override
	protected void resetImpl() {
		Log.d("wang","mHeaderImage" + mHeaderImage);

		if(anim != null) {
			anim.stop();
		}
	}



	@Override
	protected void pullToRefreshImpl() {
		Log.d("wang","pullToRefreshImpl");
		// NO-OP
	}

	@Override
	protected void releaseToRefreshImpl() {
		// NO-OP
		Log.d("wang","releaseToRefreshImpl");
	}

	@Override
	public View getHeaderImage() {
		return view.findViewById(R.id.pull_to_refresh_image1);

	}

	@Override
	public View getHeaderText() {
		Log.d("wang","Custome getHeaderText");
		return  null;
	}

	@Override
	public View getHeaderSubText() {
		Log.d("wang","Custome getHeaderSubText");
		return null;
	}

	@Override
	protected int getDefaultDrawableResId() {
		Log.d("wang","Custome getDefaultDrawableResId");
		return -1;
	}

}
```
![](https://github.com/liningwang/CustomeRefreshView/blob/master/%7D2XZ7W(%5B%5DJ1IJ09%7D7OM)JM5.png)
