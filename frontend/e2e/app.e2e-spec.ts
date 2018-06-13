import { PioFrontendPage } from './app.po';

describe('pio-frontend App', () => {
  let page: PioFrontendPage;

  beforeEach(() => {
    page = new PioFrontendPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
