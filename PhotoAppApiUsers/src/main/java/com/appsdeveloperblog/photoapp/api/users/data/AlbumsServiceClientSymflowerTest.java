package com.appsdeveloperblog.photoapp.api.users.data;

import com.appsdeveloperblog.photoapp.api.users.ui.model.AlbumResponseModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AlbumsServiceClientSymflowerTest {
	@Test
	public void getAlbumsFallback1() {
		AlbumsServiceClient a = null; // TODO This is a fallback value due to incomplete analysis.
		String id = null; // TODO This is a fallback value due to incomplete analysis.
		Throwable exception = null; // TODO This is a fallback value due to incomplete analysis.
		List<AlbumResponseModel> expected = null; // TODO This is a fallback value due to incomplete analysis.
		List<AlbumResponseModel> actual = a.getAlbumsFallback(id, exception);

		Assert.assertEquals(expected, actual);
	}
}
