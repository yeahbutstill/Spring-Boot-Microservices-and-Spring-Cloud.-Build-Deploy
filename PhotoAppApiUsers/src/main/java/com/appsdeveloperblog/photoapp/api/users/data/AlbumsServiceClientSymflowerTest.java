package com.appsdeveloperblog.photoapp.api.users.data;

import com.appsdeveloperblog.photoapp.api.users.ui.model.AlbumResponseModel;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AlbumsServiceClientSymflowerTest {
	@Test
	public void getAlbumsFallback1() {
		AlbumsServiceClient a = null; // TODO This is a fallback value due to incomplete analysis.
		String id = null; // TODO This is a fallback value due to incomplete analysis.
		Throwable exception = null; // TODO This is a fallback value due to incomplete analysis.
		List<AlbumResponseModel> expected = null; // TODO This is a fallback value due to incomplete analysis.
		List<AlbumResponseModel> actual = a.getAlbumsFallback(id, exception);

		assertEquals(expected, actual);
	}
}
