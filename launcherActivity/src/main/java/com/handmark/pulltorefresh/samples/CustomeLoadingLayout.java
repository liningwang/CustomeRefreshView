/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.handmark.pulltorefresh.samples;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;

public class CustomeLoadingLayout extends LoadingLayout {

	static final int ROTATION_ANIMATION_DURATION = 1200;

	private  Animation mRotateAnimation;
	private  Matrix mHeaderImageMatrix;
	private ImageView mHeaderImage;
	private float mRotationPivotX, mRotationPivotY;
	private View view;
	private AnimationDrawable anim;

//	private final boolean mRotateDrawableWhilePulling;

	public CustomeLoadingLayout(Context context, Mode mode, Orientation scrollDirection) {

		super(context, mode, scrollDirection, null);
		view = LayoutInflater.from(context).inflate(R.layout.pull_to_refresh_header_vertical1,null);
		setInit(view,context,mode,scrollDirection);
		mHeaderImage = (ImageView) view.findViewById(R.id.pull_to_refresh_image1);
//		mRotateDrawableWhilePulling = attrs.getBoolean(R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling, true);

		anim = (AnimationDrawable) mHeaderImage.getBackground();
//		mHeaderImage.setScaleType(ScaleType.MATRIX);
//		mHeaderImageMatrix = new Matrix();
//		mHeaderImage.setImageMatrix(mHeaderImageMatrix);
//
//		mRotateAnimation = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
//				0.5f);
////		mRotateAnimation.setInterpolator(ANIMATION_INTERPOLATOR);
//		mRotateAnimation.setDuration(ROTATION_ANIMATION_DURATION);
//		mRotateAnimation.setRepeatCount(Animation.INFINITE);
//		mRotateAnimation.setRepeatMode(Animation.RESTART);
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
